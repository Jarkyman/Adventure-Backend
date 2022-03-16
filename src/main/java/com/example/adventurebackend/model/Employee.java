package com.example.adventurebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {

  @Id
  @Column(name = "employee_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int employeeId;

  @Column(nullable = false)
  private String employeeFirstName;

  @Column(nullable = false)
  private String employeeLastName;

  @Column(nullable = false)
  private String employeePhoneNumber;

  @Column(nullable = false)
  private String employeeTitle;

  @OneToMany
  @JoinColumn(name = "employee_id")
  @JsonIgnore
  private Set<Booking> booking = new HashSet<>();

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeFirstName() {
    return employeeFirstName;
  }

  public void setEmployeeFirstName(String employeeFirstName) {
    this.employeeFirstName = employeeFirstName;
  }

  public String getEmployeeLastName() {
    return employeeLastName;
  }

  public void setEmployeeLastName(String employeeLastName) {
    this.employeeLastName = employeeLastName;
  }

  public String getEmployeePhoneNumber() {
    return employeePhoneNumber;
  }

  public void setEmployeePhoneNumber(String employeePhoneNumber) {
    this.employeePhoneNumber = employeePhoneNumber;
  }

  public String getEmployeeTitle() {
    return employeeTitle;
  }

  public void setEmployeeTitle(String employeeTitle) {
    this.employeeTitle = employeeTitle;
  }

  public Set<Booking> getBooking() {
    return booking;
  }

  public void setBooking(Set<Booking> booking) {
    this.booking = booking;
  }

  @Override
  public String toString() {
    return "Employee{"
        + "employeeId="
        + employeeId
        + ", employeeFirstName='"
        + employeeFirstName
        + '\''
        + ", employeeLastName='"
        + employeeLastName
        + '\''
        + ", employeePhoneNumber='"
        + employeePhoneNumber
        + '\''
        + ", employeeTitle='"
        + employeeTitle
        + '\''
        + ", booking="
        + booking
        + '}';
  }
}
