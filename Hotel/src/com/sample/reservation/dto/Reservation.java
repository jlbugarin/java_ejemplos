package com.sample.reservation.dto;

import java.util.Date;

public class Reservation {
    private int reservationID;
    private String guestName;
    private Date reserved_from;
    private Date reserved_to;
    private int roomNumber;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }



    public Date getReserved_from() {
        return this.reserved_from;
    }

    public void setReserved_from(Date reserved_from) {
        this.reserved_from = reserved_from;
    }

    public Date getReserved_to() {
        return this.reserved_to;
    }

    public void setReserved_to(Date reserved_to) {
        this.reserved_to = reserved_to;
    }

    public int getReservationID() {
        return this.reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public String getGuestName() {
        return this.guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

}