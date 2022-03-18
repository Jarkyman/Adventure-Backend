package com.example.adventurebackend.controller;

import com.example.adventurebackend.model.Activity;
import com.example.adventurebackend.repository.ActivityRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

// @DataJpaTest // Den hjælper med CRUD
@SpringBootTest
class ActivityControllerTest {

  @Autowired ActivityRepository activityRepository;
  @Autowired ActivityRepository activityRepository2;
  @Autowired ActivityController activityController;

  @Test
  public void testCreateActivityGivenCorrectActivityObject() {
    Activity activity = new Activity();
    activity.setActivityTitle("Test-Create-Activity");
    activity.setActivityPriceOneHour(500);

    Activity newActivity = activityController.postActivity(activity);

    assertTrue(newActivity.getActivityId() != 0);
    assertEquals("Test-Create-Activity", newActivity.getActivityTitle());
    assertEquals(500, newActivity.getActivityPriceOneHour());
    activityRepository.delete(newActivity);
  }

  @Test
  public void testCreateActivityGivenIncorrectActivityTitle() {
    Activity activity = new Activity();
    activity.setActivityTitle("TestTitle");
    activity.setActivityPriceOneHour(500);

    Activity newActivity = activityController.postActivity(activity);

    assertTrue(newActivity.getActivityId() != 0);
    assertNotEquals("WrongTitle", newActivity.getActivityTitle());
    assertEquals(500, newActivity.getActivityPriceOneHour());
    activityRepository.delete(newActivity);
  }

  @Test
  public void testCreateActivityGivenIncorrectActivityPriceOneHour() {
    Activity activity = new Activity();
    activity.setActivityTitle("TestTitle");
    activity.setActivityPriceOneHour(700);

    Activity newActivity = activityController.postActivity(activity);

    assertTrue(newActivity.getActivityId() != 0);
    assertEquals("TestTitle", newActivity.getActivityTitle());
    assertNotEquals(500, newActivity.getActivityPriceOneHour());
    activityRepository.delete(newActivity);
  }

  @Test
  public void testUpdateActivityActivityTitle() {
    int activityId = 1;
    Activity activityOld = activityRepository.findById(activityId).get();
    activityOld.setActivityTitle("nøgenløb");

    ResponseEntity<Activity> activityUpdate =
        activityController.updateActivity(activityId, activityOld);
    Activity activityUpdated = activityRepository.findById(activityId).get();

    assertEquals(activityOld.getActivityTitle(), activityUpdated.getActivityTitle());
    assertEquals(activityUpdate.getStatusCode(), HttpStatus.OK);

    // For at få orginal titlen tilbage igen efter testen
    Activity activityRestore = activityRepository.findById(activityId).get();
    activityRestore.setActivityTitle("goCart");
    Activity activityUpdate1 = activityRepository.save(activityRestore);
    Assertions.assertThat(activityUpdate1.getActivityTitle()).isEqualTo("goCart");
  }

  @Test
  public void testUpdateActivityActivityPriceOneHour() {
    int activityId = 1;
    Activity activityOld = activityRepository.findById(activityId).get();
    activityOld.setActivityPriceOneHour(500);

    ResponseEntity<Activity> activityUpdate =
        activityController.updateActivity(activityId, activityOld);
    Activity activityUpdated = activityRepository.findById(activityId).get();

    assertEquals(activityOld.getActivityPriceOneHour(), activityUpdated.getActivityPriceOneHour());
    assertEquals(activityUpdate.getStatusCode(), HttpStatus.OK);

    // For at få orginal titlen tilbage igen efter testen
    Activity activityRestore = activityRepository.findById(activityId).get();
    activityRestore.setActivityPriceOneHour(900);
    Activity activityUpdate1 = activityRepository.save(activityRestore);
    Assertions.assertThat(activityUpdate1.getActivityPriceOneHour()).isEqualTo(900);
  }

  @Test
  public void testGetJPAConnectionToDatebase() {
    assertNotNull(activityRepository);
  }

  @Test
  public void testSameConnectionOnNewRepoSingleton() {
    assertEquals(activityRepository, activityRepository2);
  }
}
