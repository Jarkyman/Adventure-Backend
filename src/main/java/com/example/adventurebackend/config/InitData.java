package com.example.adventurebackend.config;

import com.example.adventurebackend.repository.AdventuresRepository;
import com.example.adventurebackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class InitData implements CommandLineRunner {

  @Autowired AdventuresRepository adventuresRepository;

  @Autowired
  EmployeeRepository employeeRepository;

  @Override
  public void run(String... args) throws Exception {}
}
