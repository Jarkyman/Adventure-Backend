package com.example.adventurebackend.controller;

import com.example.adventurebackend.model.Activity;
import com.example.adventurebackend.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ActivityController {

  @Autowired ActivityRepository activityRepository;

  @GetMapping("/activity")
  public String test() {
    return "Hello Activity";
  }

  @GetMapping("/activities")
  public List<Activity> getAllActivities() {
    return activityRepository.findAll();
  }

  @PostMapping("/create/activity")
  @ResponseStatus(HttpStatus.CREATED)
  public Activity postActivity(@RequestBody Activity activity) {
    return activityRepository.save(activity);
  }

  @PutMapping("/update/activity/{id}")
  public ResponseEntity<Activity> updateActivity(@PathVariable("id") Long id, @RequestBody Activity activity) {
    activity.setActivityId(id);
    Optional<Activity> optionalActivity = activityRepository.findById(id);
    if (optionalActivity.isPresent()) {
      activityRepository.save(activity);
      return new ResponseEntity<Activity>(activity, HttpStatus.OK);
    }  else {
      Activity notFound = new Activity();
      notFound.setActivityTitle("Not found by id: " + id);
      return new ResponseEntity<Activity>(notFound, HttpStatus.NOT_FOUND);
    }
  }

}
