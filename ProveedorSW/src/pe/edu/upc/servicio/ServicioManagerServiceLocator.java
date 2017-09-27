/**
 * ServicioManagerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.edu.upc.servicio;

public class ServicioManagerServiceLocator extends org.apache.axis.client.Service implements pe.edu.upc.servicio.ServicioManagerService {

    public ServicioManagerServiceLocator() {
    }


    public ServicioManagerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioManagerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioManager
    private java.lang.String ServicioManager_address = "http://localhost:9080/PWS/services/ServicioManager";

    public java.lang.String getServicioManagerAddress() {
        return ServicioManager_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioManagerWSDDServiceName = "ServicioManager";

    public java.lang.String getServicioManagerWSDDServiceName() {
        return ServicioManagerWSDDServiceName;
    }

    public void setServicioManagerWSDDServiceName(java.lang.String name) {
        ServicioManagerWSDDServiceName = name;
    }

    public pe.edu.upc.servicio.ServicioManager getServicioManager() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioManager_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioManager(endpoint);
    }

    public pe.edu.upc.servicio.ServicioManager getServicioManager(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            pe.edu.upc.servicio.ServicioManagerSoapBindingStub _stub = new pe.edu.upc.servicio.ServicioManagerSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicioManagerWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioManagerEndpointAddress(java.lang.String address) {
        ServicioManager_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (pe.edu.upc.servicio.ServicioManager.class.isAssignableFrom(serviceEndpointInterface)) {
                pe.edu.upc.servicio.ServicioManagerSoapBindingStub _stub = new pe.edu.upc.servicio.ServicioManagerSoapBindingStub(new java.net.URL(ServicioManager_address), this);
                _stub.setPortName(getServicioManagerWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServicioManager".equals(inputPortName)) {
            return getServicioManager();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicio.upc.edu.pe", "ServicioManagerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicio.upc.edu.pe", "ServicioManager"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioManager".equals(portName)) {
            setServicioManagerEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
