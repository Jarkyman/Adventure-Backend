package com.example.adventurebackend.config;

import com.example.adventurebackend.repository.ActivityRepository;
import com.example.adventurebackend.repository.BookingRepository;
import com.example.adventurebackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class InitData implements CommandLineRunner {

  //Hej Alle


  @Autowired EmployeeRepository employeeRepository;

  @Autowired ActivityRepository activityRepository;

  @Autowired BookingRepository bookingRepository;

  @Override
  public void run(String... args) throws Exception {}
}
