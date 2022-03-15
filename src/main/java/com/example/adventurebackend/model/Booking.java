package com.example.adventurebackend.model;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;
=======

>>>>>>> 08c14def494b1e96a9be1b6b7c6d43e470cc4642
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {

  @Id
<<<<<<< HEAD
  @Column(name = "booking_id")
=======
  //  @Column(name = "booking_id")
>>>>>>> 08c14def494b1e96a9be1b6b7c6d43e470cc4642
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int bookingId;

  @Column(nullable = false)
  private String fullName;

  @Column(nullable = false)
  private String phoneNumber;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private LocalDate bookingDate;

  @Column(nullable = false)
  private int participants;
<<<<<<< HEAD

  @ManyToOne
  @JoinColumn(name = "activity_id")
  @JsonBackReference
  private Activity activity;

  @ManyToOne
  @JoinColumn(name = "employee_id")
  @JsonBackReference
  private Employee employee;

=======
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
>>>>>>> 08c14def494b1e96a9be1b6b7c6d43e470cc4642

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

  public Activity getActivity() {
    return activity;
  }

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

<<<<<<< HEAD
  @Override
  public String toString() {
    return "Booking{" +
        "bookingId=" + bookingId +
        ", fullName='" + fullName + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", email='" + email + '\'' +
        ", bookingDate=" + bookingDate +
        ", participants=" + participants +
        ", activity=" + activity +
        ", employee=" + employee +
        '}';
  }
=======
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
>>>>>>> 08c14def494b1e96a9be1b6b7c6d43e470cc4642
}
