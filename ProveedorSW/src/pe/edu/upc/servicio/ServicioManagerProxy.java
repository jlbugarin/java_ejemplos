package pe.edu.upc.servicio;

public class ServicioManagerProxy implements pe.edu.upc.servicio.ServicioManager {
  private String _endpoint = null;
  private pe.edu.upc.servicio.ServicioManager servicioManager = null;
  
  public ServicioManagerProxy() {
    _initServicioManagerProxy();
  }
  
  public ServicioManagerProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioManagerProxy();
  }
  
  private void _initServicioManagerProxy() {
    try {
      servicioManager = (new pe.edu.upc.servicio.ServicioManagerServiceLocator()).getServicioManager();
      if (servicioManager != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioManager)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioManager)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioManager != null)
      ((javax.xml.rpc.Stub)servicioManager)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pe.edu.upc.servicio.ServicioManager getServicioManager() {
    if (servicioManager == null)
      _initServicioManagerProxy();
    return servicioManager;
  }
  
  public java.lang.String saludo(java.lang.String nombre) throws java.rmi.RemoteException{
    if (servicioManager == null)
      _initServicioManagerProxy();
    return servicioManager.saludo(nombre);
  }
  
  
}