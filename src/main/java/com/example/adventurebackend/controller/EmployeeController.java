package com.example.adventurebackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  @GetMapping("/employee")
  public String test() {
    return "Hej employees";
  }
}

