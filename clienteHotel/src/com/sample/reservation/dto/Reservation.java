/**
 * Reservation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sample.reservation.dto;

public class Reservation  implements java.io.Serializable {
    private java.lang.String guestName;

    private int reservationID;

    private java.util.Calendar reserved_from;

    private java.util.Calendar reserved_to;

    private int roomNumber;

    public Reservation() {
    }

    public Reservation(
           java.lang.String guestName,
           int reservationID,
           java.util.Calendar reserved_from,
           java.util.Calendar reserved_to,
           int roomNumber) {
           this.guestName = guestName;
           this.reservationID = reservationID;
           this.reserved_from = reserved_from;
           this.reserved_to = reserved_to;
           this.roomNumber = roomNumber;
    }


    /**
     * Gets the guestName value for this Reservation.
     * 
     * @return guestName
     */
    public java.lang.String getGuestName() {
        return guestName;
    }


    /**
     * Sets the guestName value for this Reservation.
     * 
     * @param guestName
     */
    public void setGuestName(java.lang.String guestName) {
        this.guestName = guestName;
    }


    /**
     * Gets the reservationID value for this Reservation.
     * 
     * @return reservationID
     */
    public int getReservationID() {
        return reservationID;
    }


    /**
     * Sets the reservationID value for this Reservation.
     * 
     * @param reservationID
     */
    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }


    /**
     * Gets the reserved_from value for this Reservation.
     * 
     * @return reserved_from
     */
    public java.util.Calendar getReserved_from() {
        return reserved_from;
    }


    /**
     * Sets the reserved_from value for this Reservation.
     * 
     * @param reserved_from
     */
    public void setReserved_from(java.util.Calendar reserved_from) {
        this.reserved_from = reserved_from;
    }


    /**
     * Gets the reserved_to value for this Reservation.
     * 
     * @return reserved_to
     */
    public java.util.Calendar getReserved_to() {
        return reserved_to;
    }


    /**
     * Sets the reserved_to value for this Reservation.
     * 
     * @param reserved_to
     */
    public void setReserved_to(java.util.Calendar reserved_to) {
        this.reserved_to = reserved_to;
    }


    /**
     * Gets the roomNumber value for this Reservation.
     * 
     * @return roomNumber
     */
    public int getRoomNumber() {
        return roomNumber;
    }


    /**
     * Sets the roomNumber value for this Reservation.
     * 
     * @param roomNumber
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Reservation)) return false;
        Reservation other = (Reservation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.guestName==null && other.getGuestName()==null) || 
             (this.guestName!=null &&
              this.guestName.equals(other.getGuestName()))) &&
            this.reservationID == other.getReservationID() &&
            ((this.reserved_from==null && other.getReserved_from()==null) || 
             (this.reserved_from!=null &&
              this.reserved_from.equals(other.getReserved_from()))) &&
            ((this.reserved_to==null && other.getReserved_to()==null) || 
             (this.reserved_to!=null &&
              this.reserved_to.equals(other.getReserved_to()))) &&
            this.roomNumber == other.getRoomNumber();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getGuestName() != null) {
            _hashCode += getGuestName().hashCode();
        }
        _hashCode += getReservationID();
        if (getReserved_from() != null) {
            _hashCode += getReserved_from().hashCode();
        }
        if (getReserved_to() != null) {
            _hashCode += getReserved_to().hashCode();
        }
        _hashCode += getRoomNumber();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Reservation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.reservation.sample.com", "Reservation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guestName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.reservation.sample.com", "guestName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reservationID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.reservation.sample.com", "reservationID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reserved_from");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.reservation.sample.com", "reserved_from"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reserved_to");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.reservation.sample.com", "reserved_to"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roomNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.reservation.sample.com", "roomNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
