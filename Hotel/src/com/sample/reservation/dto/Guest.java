package com.sample.reservation.dto;

public class Guest
{
  private String name;
  private String address;
  private int age;

  public Guest(String name, String address, int age)
  {
    this.name = name;
    this.address = address;
    this.age = age;
  }

  public Guest()
  {
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}