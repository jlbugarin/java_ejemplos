package com.sample.reservation;

public class OtroServicioProxy implements com.sample.reservation.OtroServicio {
  private String _endpoint = null;
  private com.sample.reservation.OtroServicio otroServicio = null;
  
  public OtroServicioProxy() {
    _initOtroServicioProxy();
  }
  
  public OtroServicioProxy(String endpoint) {
    _endpoint = endpoint;
    _initOtroServicioProxy();
  }
  
  private void _initOtroServicioProxy() {
    try {
      otroServicio = (new com.sample.reservation.OtroServicioServiceLocator()).getOtroServicio();
      if (otroServicio != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)otroServicio)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)otroServicio)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (otroServicio != null)
      ((javax.xml.rpc.Stub)otroServicio)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sample.reservation.OtroServicio getOtroServicio() {
    if (otroServicio == null)
      _initOtroServicioProxy();
    return otroServicio;
  }
  
  public java.lang.String reservaUpc(java.lang.String nombre, int numeroHabitacion) throws java.rmi.RemoteException{
    if (otroServicio == null)
      _initOtroServicioProxy();
    return otroServicio.reservaUpc(nombre, numeroHabitacion);
  }
  
  
}