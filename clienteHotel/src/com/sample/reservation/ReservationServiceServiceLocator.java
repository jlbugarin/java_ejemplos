/**
 * ReservationServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sample.reservation;

public class ReservationServiceServiceLocator extends org.apache.axis.client.Service implements com.sample.reservation.ReservationServiceService {

    public ReservationServiceServiceLocator() {
    }


    public ReservationServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ReservationServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ReservationService
    private java.lang.String ReservationService_address = "http://localhost:9080/Hotel/services/ReservationService";

    public java.lang.String getReservationServiceAddress() {
        return ReservationService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ReservationServiceWSDDServiceName = "ReservationService";

    public java.lang.String getReservationServiceWSDDServiceName() {
        return ReservationServiceWSDDServiceName;
    }

    public void setReservationServiceWSDDServiceName(java.lang.String name) {
        ReservationServiceWSDDServiceName = name;
    }

    public com.sample.reservation.ReservationService getReservationService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ReservationService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getReservationService(endpoint);
    }

    public com.sample.reservation.ReservationService getReservationService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sample.reservation.ReservationServiceSoapBindingStub _stub = new com.sample.reservation.ReservationServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getReservationServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setReservationServiceEndpointAddress(java.lang.String address) {
        ReservationService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sample.reservation.ReservationService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sample.reservation.ReservationServiceSoapBindingStub _stub = new com.sample.reservation.ReservationServiceSoapBindingStub(new java.net.URL(ReservationService_address), this);
                _stub.setPortName(getReservationServiceWSDDServiceName());
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
        if ("ReservationService".equals(inputPortName)) {
            return getReservationService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://reservation.sample.com", "ReservationServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://reservation.sample.com", "ReservationService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ReservationService".equals(portName)) {
            setReservationServiceEndpointAddress(address);
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
