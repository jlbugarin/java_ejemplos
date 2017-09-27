package com.sample.reservation.exception;

public class GuestManagementException extends Exception {
    private String message;

    public GuestManagementException() {
    }

    public GuestManagementException(String message) {
        super(message);
    }

    public GuestManagementException(String message, Throwable cause) {
        super(message, cause);
    }

    public GuestManagementException(Throwable cause) {
        super(cause);
    }

    public String getMessage() {
        return super.getMessage();
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
