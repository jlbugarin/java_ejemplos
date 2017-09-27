package com.sample.reservation;

import com.sample.reservation.database.Storage;
import com.sample.reservation.dto.Guest;
import com.sample.reservation.exception.GuestManagementException;
import com.sample.reservation.exception.StorageException;

/*
This class is used to manage guests (add, delete and retrieve the details of guests)
 */

public class GuestManagementService {
    /**
     * Adding a new guest to the system. We create a new Guest object and
     * call addGuest() operation of Storage class to insert the new guest record to GUEST_T table
     *
     * @param name
     * @param address
     * @param age
     * @return
     * @throws GuestManagementException
     */

    public boolean addGuest(String name, String address, int age)
            throws GuestManagementException {
        
    	Guest guest = new Guest();
        guest.setName(name);
        guest.setAddress(address);
        guest.setAge(age);

        Storage storage = new Storage();
        GuestManagementException exception;
        try {
            storage.addGuest(guest);
            return true;
        } catch (StorageException e) {
            exception = new GuestManagementException();
            exception.setMessage(e.getMessage());
            e.printStackTrace();
        }
        throw exception;
    }

    /**
     * retrieving the details of a guest. By calling getGuestDetails() method of
     * Storage class, we get the corresponding guest record from GUEST_T table
     *
     * @param guestName
     * @return
     * @throws GuestManagementException
     */
    public Guest getGuestDetails(String guestName) throws GuestManagementException {
        Storage storage = new Storage();
        GuestManagementException exception;
        try {
            Guest guest = storage.getGuestDetails(guestName);
            if (guest != null) {
                return guest;
            }

            throw new GuestManagementException("Guest does not exist");
        }
        catch (StorageException e) {
            exception = new GuestManagementException();
            exception.setMessage(e.getMessage());
            e.printStackTrace();
        }
        throw exception;
    }

    /**
     * Deleting an existing guest. We call deleteGuest() method
     * of Storage class to delete a guest from GUEST_T table
     *
     * @param guestName
     * @throws GuestManagementException
     */

    public void deleteGuest(String guestName)
            throws GuestManagementException {
        Storage storage = new Storage();
        try {
            Guest guest = storage.getGuestDetails(guestName);
            storage.deleteGuest(guest.getName());
        } catch (StorageException e) {
            GuestManagementException exception = new GuestManagementException();
            exception.setMessage(e.getMessage());
            e.printStackTrace();
            throw exception;
    }
  }
}
