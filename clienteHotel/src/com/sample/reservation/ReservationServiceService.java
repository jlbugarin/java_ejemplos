/**
 * ReservationServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sample.reservation;

public interface ReservationServiceService extends javax.xml.rpc.Service {
    public java.lang.String getReservationServiceAddress();

    public com.sample.reservation.ReservationService getReservationService() throws javax.xml.rpc.ServiceException;

    public com.sample.reservation.ReservationService getReservationService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
