package com.example.adventurebackend.controller;

import com.example.adventurebackend.model.Activity;
import com.example.adventurebackend.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
