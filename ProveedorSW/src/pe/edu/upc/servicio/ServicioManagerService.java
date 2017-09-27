/**
 * ServicioManagerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.edu.upc.servicio;

public interface ServicioManagerService extends javax.xml.rpc.Service {
    public java.lang.String getServicioManagerAddress();

    public pe.edu.upc.servicio.ServicioManager getServicioManager() throws javax.xml.rpc.ServiceException;

    public pe.edu.upc.servicio.ServicioManager getServicioManager(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
