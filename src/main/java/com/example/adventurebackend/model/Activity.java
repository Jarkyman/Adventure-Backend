package com.example.adventurebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Activity {

  @Id
  @Column(name = "activity_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long activityId;

  @Column(nullable = false)
  private String activityTitle;

  @Column(nullable = false)
  private double activityPriceOneHour;

  @OneToMany
  @JoinColumn(name = "activity_id")
  @JsonIgnore
  private Set<Booking> booking = new HashSet<>();

  public Long getActivityId() {
    return activityId;
  }

  public void setActivityId(Long activityId) {
    this.activityId = activityId;
  }

  public String getActivityTitle() {
    return activityTitle;
  }

  public void setActivityTitle(String activityTitle) {
    this.activityTitle = activityTitle;
  }

  public double getActivityPriceOneHour() {
    return activityPriceOneHour;
  }

  public void setActivityPriceOneHour(double activityPriceOneHour) {
    this.activityPriceOneHour = activityPriceOneHour;
  }

  public Set<Booking> getBooking() {
    return booking;
  }

  public void setBooking(Set<Booking> booking) {
    this.booking = booking;
  }

  @Override
  public String toString() {
    return "Activity{"
        + "activityId="
        + activityId
        + ", activityTitle='"
        + activityTitle
        + '\''
        + ", activityPriceOneHour="
        + activityPriceOneHour
        + ", booking="
        + booking
        + '}';
  }
}
