package com.example.adventurebackend.controller;

import com.example.adventurebackend.model.Activity;
import com.example.adventurebackend.repository.ActivityRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ActivityControllerTest {

  @Autowired
  ActivityRepository activityRepository;
  ActivityRepository activityRepository2;


  @Test
  public void createActivity_GivenCorrectActivityInfo() {
    Activity activity1 = new Activity();
    activity1.setActivityTitle("Test-Create-Activity");
    activity1.setActivityPriceOneHour(500);
    Activity newActivity = activityRepository.save(activity1);

    assertTrue(newActivity.getActivityId() != 0);
    assertEquals("Test-Create-Activity", newActivity.getActivityTitle());
    assertEquals(500, newActivity.getActivityPriceOneHour());
  }

  @Test
  public void createActivity_GivenIncorrectActivityInfo() {
    Activity activity1 = new Activity();
    activity1.setActivityTitle("Test-Increate-Activity");
    activity1.setActivityPriceOneHour(500);
    Activity newActivity = activityRepository.save(activity1);

    assertTrue(newActivity.getActivityId() != 0);
    assertEquals("Test-Create-Activity", newActivity.getActivityTitle());
    assertEquals(500, newActivity.getActivityPriceOneHour());
  }

  @Test
  public void test_getJPAConnectionToDatebase() {
    assertNotNull(activityRepository);
  }
  @Test
  public void test_getJPAConnectionToDatebase2() {
    assertEquals(activityRepository,activityRepository2);
  }


}