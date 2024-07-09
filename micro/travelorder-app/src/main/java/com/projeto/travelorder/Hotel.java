package com.projeto.travelorder;

public class Hotel {
    private long id;
    private Long travelOrderId;
    private Integer nights;

    public Hotel() {}

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
    public Integer getNights() {
        return nights;
    }
    public void setNights(Integer nights) {
        this.nights = nights;
    }
}
