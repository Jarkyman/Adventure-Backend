package com.example.adventurebackend.controller;

import com.example.adventurebackend.model.Activity;
import com.example.adventurebackend.repository.ActivityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ActivityControllerTest {

  @Autowired ActivityRepository activityRepository;
  @Autowired ActivityRepository activityRepository2;

  @Test
  public void testCreateActivityGivenCorrectActivityObject() {
    Activity activity1 = new Activity();
    activity1.setActivityTitle("Test-Create-Activity");
    activity1.setActivityPriceOneHour(500);
    Activity newActivity = activityRepository.save(activity1);

    assertTrue(newActivity.getActivityId() != 0);
    assertEquals("Test-Create-Activity", newActivity.getActivityTitle());
    assertEquals(500, newActivity.getActivityPriceOneHour());
  }

  @Test
  public void testCreateActivityGivenIncorrectActivityTitle() {
    Activity activity1 = new Activity();
    activity1.setActivityTitle("TestTitle");
    activity1.setActivityPriceOneHour(500);
    Activity newActivity = activityRepository.save(activity1);

    assertTrue(newActivity.getActivityId() != 0);
    assertNotEquals("WrongTitle", newActivity.getActivityTitle());
    assertEquals(500, newActivity.getActivityPriceOneHour());
  }

  @Test
  public void testCreateActivityGivenIncorrectActivityPriceOneHour() {
    Activity activity1 = new Activity();
    activity1.setActivityTitle("TestTitle");
    activity1.setActivityPriceOneHour(700);
    Activity newActivity = activityRepository.save(activity1);

    assertTrue(newActivity.getActivityId() != 0);
    assertEquals("TestTitle", newActivity.getActivityTitle());
    assertNotEquals(500, newActivity.getActivityPriceOneHour());
  }

  @Test
  public void testGetJPAConnectionToDatebase() {
    assertNotNull(activityRepository);
  }

  @Test
  public void testGetJPAConnectionToDatebase2() { //TODO den skal hedde noget andet
    assertEquals(activityRepository, activityRepository2);
  }
}
