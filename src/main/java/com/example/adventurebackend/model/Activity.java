package com.example.adventurebackend.model;

import javax.persistence.*;

@Entity
public class Activity {

  @Id
  @Column(name="activity_id")
//  @ManyToOne
//  @JoinColumn(name="booking_id")
  private String activityId;
  private String activityTitle;
  private double activityPriceOneHour;


  public String getActivityId() {
    return activityId;
  }

  public void setActivityId(String activityId) {
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

  @Override
  public String toString() {
    return "Activity{" +
        "activityId='" + activityId + '\'' +
        ", activityTitle='" + activityTitle + '\'' +
        ", activityPriceOneHour=" + activityPriceOneHour +
        '}';
  }
}
