package com.example.adventurebackend.controller;

import com.example.adventurebackend.model.Activity;
import com.example.adventurebackend.repository.ActivityRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

// @DataJpaTest // Den hjælper med CRUD
@SpringBootTest
class ActivityControllerTest {

  @Autowired
  ActivityRepository activityRepository;
  @Autowired
  ActivityRepository activityRepository2;

  @Test
  public void testCreateActivityGivenCorrectActivityObject() {
    Activity activity1 = new Activity();
    activity1.setActivityTitle("Test-Create-Activity");
    activity1.setActivityPriceOneHour(500);
    Activity newActivity = activityRepository.save(activity1);

    assertTrue(newActivity.getActivityId() != 0);
    assertEquals("Test-Create-Activity", newActivity.getActivityTitle());
    assertEquals(500, newActivity.getActivityPriceOneHour());
    activityRepository.delete(newActivity);
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
    activityRepository.delete(newActivity);
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
    activityRepository.delete(newActivity);
  }

  @Test
  public void testUpdateActivity_ActivityTitle() {
    Activity activity1 = activityRepository.findById(1).get();
    activity1.setActivityTitle("nøgenløb");
    Activity activityUpdate = activityRepository.save(activity1);
    Assertions.assertThat(activityUpdate.getActivityTitle()).isEqualTo("nøgenløb");

    // For at få orginal titlen tilbage igen efter testen
    Activity activityRestore = activityRepository.findById(1).get();
    activityRestore.setActivityTitle("goCart");
    Activity activityUpdate1 = activityRepository.save(activityRestore);
    Assertions.assertThat(activityUpdate1.getActivityTitle()).isEqualTo("goCart");
  }

  @Test
  public void testUpdateActivity_ActivityPriceOneHour() {
    //Arrange
    Activity activity1 = activityRepository.findById(1).get();
    activity1.setActivityPriceOneHour(500);
    //Act
    Activity activityUpdate = activityRepository.save(activity1);
    //Assert
    Assertions.assertThat(activityUpdate.getActivityPriceOneHour()).isEqualTo(500);

    // For at få orginal price tilbage igen efter testen
    Activity activityRestore = activityRepository.findById(1).get();
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