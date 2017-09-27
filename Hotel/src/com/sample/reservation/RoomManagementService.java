package com.sample.reservation;

import com.sample.reservation.database.Storage;
import com.sample.reservation.dto.Room;
import com.sample.reservation.exception.RoomManagementException;
import com.sample.reservation.exception.StorageException;

/**
 * This class is used for hotel room management (adding new rooms, deleting rooms and retrieving the details of existing rooms)
 */

public class RoomManagementService {

    /**
     * Adding a new room to the system. We create a new Room object and
     * call addRoom() operation of Storage class to insert the new room record to ROOM_T table
     *
     * @param roomNumber
     * @param roomType
     * @param roomSize
     * @return
     * @throws RoomManagementException
     */
    public boolean addRoom(int roomNumber, String roomType, String roomSize)
            throws RoomManagementException {
        Room room = new Room();
        room.setRoomNumber(roomNumber);
        room.setRoomType(roomType);
        room.setRoomSize(roomSize);

        Storage storage = new Storage();
        RoomManagementException exception;
        try {
            storage.addRoom(room);
            return true;
        } catch (StorageException e) {
            exception = new RoomManagementException();
            exception.setMessage(e.getMessage());
            e.printStackTrace();
        }
        throw exception;
    }

    /**
     * retrieving the details of a room. By calling getRoomDetails() method of
     * Storage class, we get the corresponding room record from ROOM_T table
     *
     * @param roomNumber
     * @return
     * @throws RoomManagementException
     */
    public Room getRoomDetails(int roomNumber) throws RoomManagementException {
        Storage storage = new Storage();
        RoomManagementException exception;
        try {
            Room room = storage.getRoomDetails(roomNumber);
            if (room != null) {
                return room;
            }

            throw new RoomManagementException("Room does not exist");
        }
        catch (StorageException e) {
            exception = new RoomManagementException();
            exception.setMessage(e.getMessage());
            e.printStackTrace();
        }
        throw exception;
    }

    /**
     * Deleting an existing room. We call deleteRoom() method
     * of Storage class to delete a room from ROOM_T table
     *
     * @param roomNumber
     * @throws RoomManagementException
     */

    public void deleteRoom(int roomNumber)
            throws RoomManagementException {
        Storage storage = new Storage();
        try {
            Room room = storage.getRoomDetails(roomNumber);
            storage.deleteRoom(room.getRoomNumber());
        } catch (StorageException e) {
            RoomManagementException exception = new RoomManagementException();
            exception.setMessage(e.getMessage());
            e.printStackTrace();
            throw exception;
    }
  }
}
