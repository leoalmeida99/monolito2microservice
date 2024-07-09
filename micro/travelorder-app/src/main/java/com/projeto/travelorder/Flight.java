package com.projeto.travelorder;

public class Flight {
    private long id;
    private Long travelOrderId;
    private String fromAirport;
    private String toAirport;
    
    public Flight() {}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Long getTravelOrderId() {
        return travelOrderId;
    }
    public void setTravelOrderId(Long travelOrderId) {
        this.travelOrderId = travelOrderId;
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
}
