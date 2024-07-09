package com.projeto.travelorder;

import com.projeto.flight.Flight;
import com.projeto.hotel.Hotel;

public class TravelOrderDTO {
    private String fromAirport;
    private String toAirport;
    private Integer nights;

    public TravelOrderDTO() {}

    private TravelOrderDTO(String fromAirport, String toAirport, Integer nights) {
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.nights = nights;
    }

    public static TravelOrderDTO of(TravelOrder travelOrder, Flight flight, Hotel hotel) {
        if (flight == null) {
            flight = new Flight();
        }

        if (hotel == null) {
            hotel = new Hotel();
        }

        return new TravelOrderDTO(flight.fromAirport, flight.toAirport, hotel.nights);
    }

    public static TravelOrderDTO of(String fromAirport, String toAirport, Integer nights) {
        return new TravelOrderDTO(fromAirport, toAirport, nights);
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public Integer getNights() {
        return nights;
    }

    public void setNights(Integer nights) {
        this.nights = nights;
    }
}