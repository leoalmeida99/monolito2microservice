package com.projeto.travelorder;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("travelorder")
public class TravelOrderResource {
    
    @Inject
    @RestClient
    FlightService flightService;
    
    @Inject
    @RestClient
    HotelService hotelService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravelOrderDTO> orders() {
        return TravelOrder.<TravelOrder>listAll().stream()
                .map(
                    order -> TravelOrderDTO.of(
                        order, 
                        flightService.findByTravelOrderId(order.id),
                        hotelService.findByTravelOrderId(order.id)
                    )
                ).collect(Collectors.toList());
    }

    @GET
    @Path("findById")
    public TravelOrder findById(@QueryParam("id") long id) {
        return TravelOrder.findById(id);
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TravelOrder newTravelOrder(TravelOrderDTO travelOrderDTO) {
        TravelOrder travelOrder = new TravelOrder();
        travelOrder.id = null;
        travelOrder.persist();

        Flight flight = new Flight();
        flight.setFromAirport(travelOrderDTO.getFromAirport());
        flight.setToAirport(travelOrderDTO.getToAirport());
        flight.setTravelOrderId(travelOrder.id);
        flightService.newFlight(flight);

        Hotel hotel = new Hotel();
        hotel.setNights(travelOrderDTO.getNights());
        hotel.setTravelOrderId(travelOrder.id);
        hotelService.newHotel(hotel);

        return travelOrder;
    }
}