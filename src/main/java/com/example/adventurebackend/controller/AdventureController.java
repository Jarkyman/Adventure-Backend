package com.example.adventurebackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdventureController {

  @GetMapping("/")
  public String test() {
    return "Hello World";
  }
}
