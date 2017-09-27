/**
 * ReservationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sample.reservation;

public interface ReservationService extends java.rmi.Remote {
    public boolean addReservation(int roomNumber, java.lang.String guestName, java.util.Calendar reserved_from, java.util.Calendar reserved_to) throws java.rmi.RemoteException, com.sample.reservation.exception.ReservationManagementException;
    public com.sample.reservation.dto.Reservation getReservationDetails(int roomNumber) throws java.rmi.RemoteException, com.sample.reservation.exception.ReservationManagementException;
    public void removeReservation(int reservationID) throws java.rmi.RemoteException, com.sample.reservation.exception.ReservationManagementException;
}
