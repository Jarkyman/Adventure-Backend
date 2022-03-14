package com.example.adventurebackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {


  @GetMapping("/activity")
  public String test() {
    return "Hello Activity";
  }
}
