package com.example.adventurebackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Booking {

  @Id
  @Column(name = "booking_id")
  private String bookingId;

  private String fullName;
  private String phoneNumber;
  private String email;
  private LocalDate bookingDate;
  private int participants;

  @OneToMany
  @JoinColumn(name = "activity_id")
  @JsonBackReference
  private Set<Activity> bookingActivity = new HashSet<>();

  @OneToMany
  @JoinColumn(name = "employee_id")
  private Set<Employee> bookingEmployee = new HashSet<>();

  public String getBookingId() {
    return bookingId;
  }

  public void setBookingId(String bookingId) {
    this.bookingId = bookingId;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getBookingDate() {
    return bookingDate;
  }

  public void setBookingDate(LocalDate bookingDate) {
    this.bookingDate = bookingDate;
  }

  public int getParticipants() {
    return participants;
  }

  public void setParticipants(int participants) {
    this.participants = participants;
  }

  public Set<Activity> getBookingActivity() {
    return bookingActivity;
  }

  public void setBookingActivity(Set<Activity> bookingActivity) {
    this.bookingActivity = bookingActivity;
  }

  public Set<Employee> getBookingEmployee() {
    return bookingEmployee;
  }

  public void setBookingEmployee(Set<Employee> bookingEmployee) {
    this.bookingEmployee = bookingEmployee;
  }

  @Override
  public String toString() {
    return "Booking{"
        + "bookingId='"
        + bookingId
        + '\''
        + ", fullName='"
        + fullName
        + '\''
        + ", phoneNumber='"
        + phoneNumber
        + '\''
        + ", email='"
        + email
        + '\''
        + ", bookingDate="
        + bookingDate
        + ", participants="
        + participants
        + ", bookingActivity="
        + bookingActivity
        + ", bookingEmployee="
        + bookingEmployee
        + '}';
  }
}
