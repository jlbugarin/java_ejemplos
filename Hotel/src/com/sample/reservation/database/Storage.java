package com.sample.reservation.database;

import com.sample.reservation.dto.Guest;
import com.sample.reservation.dto.Reservation;
import com.sample.reservation.dto.Room;
import com.sample.reservation.exception.GuestManagementException;
import com.sample.reservation.exception.ReservationManagementException;
import com.sample.reservation.exception.RoomManagementException;
import com.sample.reservation.exception.StorageException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Storage {

    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
    Properties properties = new Properties();


    //The method corresponding to addGuest() in GuestManagementService
    // This is used to add a new guest to GUEST_T table
    public boolean addGuest(Guest guest) throws StorageException, GuestManagementException {

        //Check whether the guest already exists before adding a new guest
        if (getGuestDetails(guest.getName()) == null) {

            try {
                connection = getConnection();
                statement = connection.createStatement();

                //Execute INSERT SQL Query to add a new row to GUEST_T table

                String sqlStatement = "INSERT INTO GUEST_T VALUES ('" + guest.getName()
                                      + "','" + guest.getAddress() + "', " + guest.getAge() + ")";
                statement.execute(sqlStatement);
                return true;
            } catch (SQLException e) {
                throw new StorageException("Can not execute the sql query", e);
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {

            throw new GuestManagementException("Guest already Exists");

        }

    }

    //The method corresponding to addRoom() in RoomManagementService.
    // This is used to add a new room to ROOM_T table
    public boolean addRoom(Room room) throws StorageException, RoomManagementException {

        //Check whether the room already exists before adding a new room
        if (getRoomDetails(room.getRoomNumber()) == null) {
            try {
                connection = getConnection();
                statement = connection.createStatement();
                //Execute INSERT SQL Query to add a new row to ROOM_T table
                String sqlStatement = "insert into ROOM_T values ('" + room.getRoomNumber()
                                      + "','" + room.getRoomType() + "', '" + room.getRoomSize() + "')";
                statement.execute(sqlStatement);
                return true;
            } catch (SQLException e) {
                throw new StorageException("Can not execute the sql query", e);
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        } else {
            throw new RoomManagementException("Room already Exists");
        }


    }

    //The method corresponding to addReservation() in ReservationService.
    // This is used to do a new reservation
    public boolean addReservation(Reservation reservation)
            throws StorageException, ReservationManagementException {
        //Check whether a reservation already done for the given guest and room
        if (proceedReservation(reservation.getGuestName(), reservation.getRoomNumber())) {
            try {
                connection = getConnection();
                statement = connection.createStatement();
                //Execute INSERT SQL Query to add a new row to RESERVATION_T table
                String sqlStatement = "insert into RESERVATION_T(guest_name,room_no,reserved_from,reserved_to) values ('" + reservation.getGuestName()
                                      + "','" + reservation.getRoomNumber() + "', '" + new java.sql.Date(reservation.getReserved_from().getTime()) + "', '" + new java.sql.Date(reservation.getReserved_to().getTime()) + "')";


                statement.execute(sqlStatement);
                return true;
            } catch (SQLException e) {
                throw new StorageException("Can not execute the sql query", e);
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        } else {
            throw new ReservationManagementException("Reservation already Exists");
        }


    }

    //This method is used to verify whether the pre-requisites are satisfied before a reservation is done

    public boolean proceedReservation(String guest_name, int roomNumber) throws StorageException {
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        ResultSet rs4 = null;
        Statement statement1 = null;
        Statement statement2 = null;
        Statement statement3 = null;
        Statement statement4 = null;

        connection = getConnection();
        try {
            statement1 = connection.createStatement();
            statement2 = connection.createStatement();
            statement3 = connection.createStatement();
            statement4 = connection.createStatement();
        } catch (SQLException e) {
            throw new StorageException("Can not execute the sql query", e);
        }
        //Execute the necessary sql queries before adding a new reservation
        String sqlStatement1 = "SELECT guest_name, room_no FROM RESERVATION_T where guest_name='" + guest_name + "'";
        String sqlStatement2 = "SELECT guest_name, room_no FROM RESERVATION_T where room_no='" + roomNumber + "'";
        String sqlStatement3 = "SELECT name FROM GUEST_T where name='" + guest_name + "'";
        String sqlStatement4 = "SELECT room_number FROM ROOM_T where room_number='" + roomNumber + "'";
        boolean proceedReservation;
        try {
            rs1 = statement1.executeQuery(sqlStatement1);
            rs2 = statement2.executeQuery(sqlStatement2);
            rs3 = statement3.executeQuery(sqlStatement3);
            rs4 = statement4.executeQuery(sqlStatement4);
            if (rs3.next() == true && rs4.next() == true && rs1.next() == false && rs2.next() == false) {
                proceedReservation = true;
                
            } else {
                proceedReservation = false;
            }

        } catch (SQLException e) {
            throw new StorageException("Can not execute the sql query", e);
        } finally {
            try {
                statement1.close();
                connection.close();
            } catch (Exception e) {
                throw new StorageException("Error occurred while closing the connection");
            }
        }

        return proceedReservation;
    }

    //The method corresponding to the getRoomDetails() in RoomManagementService
    // This is used to get details of a particular room from ROOM_T table
    public Room getRoomDetails(int roomNumber) throws StorageException {


        int roomNo = 0;
        String roomType = null;
        String roomSize = null;

        connection = getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new StorageException("Can not execute the sql query", e);
        }
        //Execute SELECT SQL Query to retrieve the corresponding row from ROOM_T table
        String sqlStatement = "SELECT * FROM ROOM_T where room_number = '" + roomNumber + "'";
        try {
            rs = statement.executeQuery(sqlStatement);

            Room room = null;
            while (rs.next()) {
                room = new Room();

                roomNo = rs.getInt("room_number");
                roomType = rs.getString("room_type");
                roomSize = rs.getString("room_size");

                room.setRoomNumber(roomNo);
                room.setRoomType(roomType);
                room.setRoomSize(roomSize);

            }
            return room;
        } catch (SQLException e) {
            throw new StorageException("Can not execute the sql query", e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
                throw new StorageException("Error occurred while closing the connection");
            }
        }


    }

    //The method corresponding to the getReservationDetails() in ReservationService
    // This is used to get details of a particular reservation from RESERVATION_T table

    public Reservation getReservationDetails(int roomNumber) throws StorageException {

        int resID = 0;
        String guestName = null;
        Date reservedFrom = null;
        Date reservedTo = null;


        connection = getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new StorageException("Can not execute the sql query", e);
        }

        //Execute SELECT SQL Query to retrieve the corresponding row from RESERVATION_T table
        String sqlStatement = "SELECT * FROM RESERVATION_T where room_no = '" + roomNumber + "'";
        try {
            rs = statement.executeQuery(sqlStatement);

            Reservation reservation = null;
            while (rs.next()) {
                reservation = new Reservation();

                resID = rs.getInt("res_id");
                guestName = rs.getString("guest_name");
                roomNumber = rs.getInt("room_no");
                reservedFrom = rs.getDate("reserved_from");
                reservedTo = rs.getDate("reserved_to");

                reservation.setReservationID(resID);
                reservation.setGuestName(guestName);
                reservation.setRoomNumber(roomNumber);
                reservation.setReserved_from(reservedFrom);
                reservation.setReserved_to(reservedTo);


            }
            return reservation;
        } catch (SQLException e) {
            throw new StorageException("Can not execute the sql query", e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
                throw new StorageException("Error occurred while closing the connection");
            }
        }


    }

    //The method corresponding to the getGuestDetails() in GuestManagementService.
    // This is used to get details of a particular guest from GUEST_T table
    public Guest getGuestDetails(String name) throws StorageException {

        String guestName = null;
        String guestAddress = null;
        int guestAge = 0;


        connection = getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new StorageException("Can not execute the sql query", e);
        }

        //Execute SELECT SQL Query to retrieve the corresponding row from GUEST_T table

        String sqlStatement = "SELECT * FROM GUEST_T WHERE name = '" + name + "'";
        try {
            rs = statement.executeQuery(sqlStatement);

            Guest guest = null;
            while (rs.next()) {
                guest = new Guest();

                guestName = rs.getString("name");
                guestAddress = rs.getString("address");
                guestAge = rs.getInt("age");

                guest.setName(guestName);
                guest.setAge(guestAge);
                guest.setAddress(guestAddress);

            }
            return guest;
        } catch (SQLException e) {
            throw new StorageException("Can not execute the sql query", e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
                throw new StorageException("Error occurred while closing the connection");
            }
        }

    }

    //The method corresponding to the deleteGuest() in GuestManagementService
    //This is used to delete a guest from GUEST_T table
    public void deleteGuest(String name) throws StorageException, GuestManagementException {

        if (getGuestDetails(name) != null) {

            try {
                connection = getConnection();
                statement = connection.createStatement();

                //Execute DELETE SQL Query to retrieve the corresponding row from GUEST_T table
                String sqlStatement = "DELETE FROM GUEST_T WHERE name = '" + name + "'";
                statement.execute(sqlStatement);
            } catch (SQLException e) {
                throw new StorageException("Can not execute the sql query", e);
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {

            throw new GuestManagementException("Guest does not Exist");

        }

    }

    //The method corresponding to the deleteRoom() in RoomManagementService
    //This is used to delete a room from ROOM_T table
    public void deleteRoom(int roomNumber) throws StorageException, RoomManagementException {

        if (getRoomDetails(roomNumber) != null) {

            try {
                connection = getConnection();
                statement = connection.createStatement();
                String sqlStatement = "delete from ROOM_T where room_number = '" + roomNumber + "'";
                statement.execute(sqlStatement);
            } catch (SQLException e) {
                throw new StorageException("Can not execute the sql query", e);
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {

            throw new RoomManagementException("Room does not Exist");

        }

    }

    //This method takes care of establishing the jdbc connection with HOTEL_RESERVATION_DB

    private Connection getConnection() throws StorageException {
        String driverName = "com.mysql.jdbc.Driver";
        String host = null;
        String port = null;
        String userName = null;
        String password = null;
        String conectionURI = null;

        try {
            //Read the mysql database details from mysql.properties file which can be found at the conf directory of Axis2 service archive (aar)
            InputStream propertyInputStream = this.getClass().getClassLoader().getResourceAsStream("conf/mysql.properties");
            properties.load(propertyInputStream);
            userName = properties.getProperty("mysql.username");
            password = properties.getProperty("mysql.password");
            host = properties.getProperty("mysql.host");
            port = properties.getProperty("mysql.port");

            conectionURI = "jdbc:mysql://" + host + ":" + port + "/HOTEL_RESERVATION_DB";
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            Class driverClass = Class.forName(driverName);
            Connection connection = DriverManager.getConnection(conectionURI, userName, password);
            connection.setAutoCommit(true);
            return connection;
        } catch (ClassNotFoundException e) {
            throw new StorageException("Can not find the driver class ", e);
        } catch (SQLException e) {
            throw new StorageException("Can not get the data base conneciton", e);
        }
    }

    public void removeReservation(int reservationID)
            throws StorageException, ReservationManagementException {
        try {
            connection = getConnection();
            statement = connection.createStatement();

            String sqlStatement = "DELETE FROM RESERVATION_T WHERE res_id = " + reservationID + "";
            statement.execute(sqlStatement);
        } catch (SQLException e) {
            throw new StorageException("Can not execute the sql query", e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
