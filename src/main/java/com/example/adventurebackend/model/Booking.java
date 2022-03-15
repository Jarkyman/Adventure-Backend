package com.example.adventurebackend.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {

  @Id
  //  @Column(name = "booking_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int bookingId;

  private String fullName;
  private String phoneNumber;
  private String email;
  private LocalDate bookingDate;
  private int participants;
  private String bookingActivity;
  private String bookingEmployee;

  //  @OneToMany
  //  @JoinColumn(name = "activity_id")
  //  @JsonBackReference
  //  private Set<Activity> bookingActivity = new HashSet<>();
  //
  //  @OneToMany
  //  @JoinColumn(name = "employee_id")
  //  private Set<Employee> bookingEmployee = new HashSet<>();

  public int getBookingId() {
    return bookingId;
  }

  public void setBookingId(int bookingId) {
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

  public String getBookingActivity() {
    return bookingActivity;
  }

  public void setBookingActivity(String bookingActivity) {
    this.bookingActivity = bookingActivity;
  }

  public String getBookingEmployee() {
    return bookingEmployee;
  }

  public void setBookingEmployee(String bookingEmployee) {
    this.bookingEmployee = bookingEmployee;
  }

  //  public Set<Activity> getBookingActivity() {
  //    return bookingActivity;
  //  }
  //
  //  public void setBookingActivity(Set<Activity> bookingActivity) {
  //    this.bookingActivity = bookingActivity;
  //  }
  //
  //  public Set<Employee> getBookingEmployee() {
  //    return bookingEmployee;
  //  }
  //
  //  public void setBookingEmployee(Set<Employee> bookingEmployee) {
  //    this.bookingEmployee = bookingEmployee;
  //  }

  @Override
  public String toString() {
    return "Booking{"
        + "bookingId="
        + bookingId
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
        + ", bookingActivity='"
        + bookingActivity
        + '\''
        + ", bookingEmployee='"
        + bookingEmployee
        + '\''
        + '}';
  }

  //  @Override
  //  public String toString() {
  //    return "Booking{"
  //        + "bookingId='"
  //        + bookingId
  //        + '\''
  //        + ", fullName='"
  //        + fullName
  //        + '\''
  //        + ", phoneNumber='"
  //        + phoneNumber
  //        + '\''
  //        + ", email='"
  //        + email
  //        + '\''
  //        + ", bookingDate="
  //        + bookingDate
  //        + ", participants="
  //        + participants
  //        + ", bookingActivity="
  //        + bookingActivity
  //        + ", bookingEmployee="
  //        + bookingEmployee
  //        + '}';
  //  }
}
