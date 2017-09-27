package com.sample.reservation;

public class ReservationServiceProxy implements com.sample.reservation.ReservationService {
  private String _endpoint = null;
  private com.sample.reservation.ReservationService reservationService = null;
  
  public ReservationServiceProxy() {
    _initReservationServiceProxy();
  }
  
  public ReservationServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initReservationServiceProxy();
  }
  
  private void _initReservationServiceProxy() {
    try {
      reservationService = (new com.sample.reservation.ReservationServiceServiceLocator()).getReservationService();
      if (reservationService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)reservationService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)reservationService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (reservationService != null)
      ((javax.xml.rpc.Stub)reservationService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sample.reservation.ReservationService getReservationService() {
    if (reservationService == null)
      _initReservationServiceProxy();
    return reservationService;
  }
  
  public boolean addReservation(int roomNumber, java.lang.String guestName, java.util.Calendar reserved_from, java.util.Calendar reserved_to) throws java.rmi.RemoteException, com.sample.reservation.exception.ReservationManagementException{
    if (reservationService == null)
      _initReservationServiceProxy();
    return reservationService.addReservation(roomNumber, guestName, reserved_from, reserved_to);
  }
  
  public com.sample.reservation.dto.Reservation getReservationDetails(int roomNumber) throws java.rmi.RemoteException, com.sample.reservation.exception.ReservationManagementException{
    if (reservationService == null)
      _initReservationServiceProxy();
    return reservationService.getReservationDetails(roomNumber);
  }
  
  public void removeReservation(int reservationID) throws java.rmi.RemoteException, com.sample.reservation.exception.ReservationManagementException{
    if (reservationService == null)
      _initReservationServiceProxy();
    reservationService.removeReservation(reservationID);
  }
  
  
}