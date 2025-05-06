package com.pluralsight;

public class Reservation {
    private String roomType;
    private double price;
    private int numberOfNights;
    private boolean weekend;
    private double reservationTotal;

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() throws Exception {
        double basePrice = 0;

        if(roomType.equalsIgnoreCase("King")) {
            basePrice = 139;
        } else if(roomType.equalsIgnoreCase("Double")) {
            basePrice = 124;
        } else {
            throw new Exception("Invalid room type");
        }

        if(this.weekend){
            basePrice *= 1.10;
        }
        return basePrice;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public void setWeekend(boolean weekend) {
        weekend = weekend;
    }

    public double getReservationTotal() {
        return reservationTotal;
    }
}
