package com.projeto.hotel;

import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("hotel")
public class HotelResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hotel> hotels() {
        return Hotel.listAll(); 
    }

    @GET
    @Path("findById")
    public Hotel findById(@QueryParam("id") long id) {
        return Hotel.findById(id);
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Hotel newHotel(Hotel hotel) {
        hotel.id = null;
        hotel.persist();

        return hotel;
    }
}