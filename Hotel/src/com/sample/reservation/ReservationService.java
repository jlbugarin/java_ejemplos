package com.sample.reservation;

import com.sample.reservation.database.Storage;
import com.sample.reservation.dto.Reservation;
import com.sample.reservation.exception.ReservationManagementException;
import com.sample.reservation.exception.StorageException;

import java.util.Date;

/**
 * this service manages the room reservations of Hotel management system
 */


public class ReservationService {


    /**
     * This method is used to add a new reservation for a given guest
     *
     * @param roomNumber
     * @param guestName
     * @param reserved_from
     * @param reserved_to
     * @return
     * @throws ReservationManagementException
     */

    public boolean addReservation(int roomNumber, String guestName, Date reserved_from,
                                  Date reserved_to)
            throws ReservationManagementException {
        
    	Reservation reservation = new Reservation();
        reservation.setRoomNumber(roomNumber);
        reservation.setGuestName(guestName);
        reservation.setReserved_from(reserved_from);
        reservation.setReserved_to(reserved_to);

        Storage storage = new Storage();
        ReservationManagementException exception;
        try {
            storage.addReservation(reservation);
            return true;
        } catch (StorageException e) {
            exception = new ReservationManagementException();
            exception.setMessage(e.getMessage());
            e.printStackTrace();
        }
        throw exception;
    }

    /**
     * This method is used to find out the reservation details of a given room
     *
     * @param RoomNumber
     * @return
     * @throws ReservationManagementException
     */


    public Reservation getReservationDetails(int RoomNumber) throws ReservationManagementException {
        Storage storage = new Storage();
        ReservationManagementException exception;
        try {
            Reservation reservation = storage.getReservationDetails(RoomNumber);
            if (reservation != null) {
                return reservation;
            }

            throw new ReservationManagementException("No Reservation done!");
        }
        catch (StorageException e) {
            exception = new ReservationManagementException();
            exception.setMessage(e.getMessage());
            e.printStackTrace();
        }
        throw exception;
    }


    /**
     * This method is used to remove an existing reesrvation
     *
     * @param reservationID
     * @throws ReservationManagementException
     */
    public void removeReservation(int reservationID)
            throws ReservationManagementException {
        Storage storage = new Storage();
        try {
            storage.removeReservation(reservationID);
        } catch (StorageException e) {
            ReservationManagementException exception = new ReservationManagementException();
            exception.setMessage(e.getMessage());
            e.printStackTrace();
            throw exception;
        }
    }
}
