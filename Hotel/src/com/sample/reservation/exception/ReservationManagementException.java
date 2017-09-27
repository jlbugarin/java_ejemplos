package com.sample.reservation.exception;

public class ReservationManagementException extends Exception {
    private String message;

    public ReservationManagementException() {
    }

    public ReservationManagementException(String message) {
        super(message);
    }

    public ReservationManagementException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReservationManagementException(Throwable cause) {
        super(cause);
    }

    public String getMessage() {
        return super.getMessage();
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
