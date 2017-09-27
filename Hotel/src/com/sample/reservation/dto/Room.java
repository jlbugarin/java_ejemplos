package com.sample.reservation.dto;

public class Room
{
  private int roomNumber;
  private String roomType;
  private String roomSize;

  public Room(int roomNumber, String roomType, String roomSize)
  {
    this.roomNumber = roomNumber;
    this.roomType = roomType;
    this.roomSize = roomSize;
  }

  public Room()
  {
  }

  public int getRoomNumber() {
    return this.roomNumber;
  }

  public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
  }

  public String getRoomType() {
    return this.roomType;
  }

  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }

  public String getRoomSize() {
    return this.roomSize;
  }

  public void setRoomSize(String roomSize) {
    this.roomSize = roomSize;
  }
}
