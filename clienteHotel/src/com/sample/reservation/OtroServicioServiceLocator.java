/**
 * OtroServicioServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sample.reservation;

public class OtroServicioServiceLocator extends org.apache.axis.client.Service implements com.sample.reservation.OtroServicioService {

    public OtroServicioServiceLocator() {
    }


    public OtroServicioServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public OtroServicioServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for OtroServicio
    private java.lang.String OtroServicio_address = "http://localhost:9080/Hotel/services/OtroServicio";

    public java.lang.String getOtroServicioAddress() {
        return OtroServicio_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String OtroServicioWSDDServiceName = "OtroServicio";

    public java.lang.String getOtroServicioWSDDServiceName() {
        return OtroServicioWSDDServiceName;
    }

    public void setOtroServicioWSDDServiceName(java.lang.String name) {
        OtroServicioWSDDServiceName = name;
    }

    public com.sample.reservation.OtroServicio getOtroServicio() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(OtroServicio_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getOtroServicio(endpoint);
    }

    public com.sample.reservation.OtroServicio getOtroServicio(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sample.reservation.OtroServicioSoapBindingStub _stub = new com.sample.reservation.OtroServicioSoapBindingStub(portAddress, this);
            _stub.setPortName(getOtroServicioWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setOtroServicioEndpointAddress(java.lang.String address) {
        OtroServicio_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sample.reservation.OtroServicio.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sample.reservation.OtroServicioSoapBindingStub _stub = new com.sample.reservation.OtroServicioSoapBindingStub(new java.net.URL(OtroServicio_address), this);
                _stub.setPortName(getOtroServicioWSDDServiceName());
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
        if ("OtroServicio".equals(inputPortName)) {
            return getOtroServicio();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://reservation.sample.com", "OtroServicioService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://reservation.sample.com", "OtroServicio"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("OtroServicio".equals(portName)) {
            setOtroServicioEndpointAddress(address);
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
