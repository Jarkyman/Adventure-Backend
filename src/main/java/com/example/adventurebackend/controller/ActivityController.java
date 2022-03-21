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

  @Autowired
  ActivityRepository activityRepository;

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
  public ResponseEntity<Activity> updateActivity(@PathVariable int id, @RequestBody Activity activity) {
    activity.setActivityId(id);
    Optional<Activity> optionalActivity = activityRepository.findById(id);
    if (optionalActivity.isPresent()) {
      activityRepository.save(activity);
      return new ResponseEntity<>(activity, HttpStatus.OK);
    } else {
      Activity notFound = new Activity();
      notFound.setActivityTitle("Not found by id: " + id);
      return new ResponseEntity<>(notFound, HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/delete/activity/{id}")
  public ResponseEntity<String> deleteActivity(@PathVariable int id) {
    try {
      activityRepository.deleteById(id);
      return new ResponseEntity<>("delete id = " + id, HttpStatus.OK);
    } catch (Exception err) {
      return new ResponseEntity<>("Could not id at all = " + id, HttpStatus.NOT_FOUND);
    }
  }

}
