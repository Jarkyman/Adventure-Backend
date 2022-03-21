package com.example.adventurebackend.controller;

import com.example.adventurebackend.model.Employee;
import com.example.adventurebackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class EmployeeController {

  @Autowired EmployeeRepository employeeRepository;

  @GetMapping("/employee")
  public String test() {
    return "Hej employees";
  }

  @GetMapping("/employees")
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  @PostMapping("/create/employee")
  @ResponseStatus(HttpStatus.CREATED)
  public Employee createEmployee(@RequestBody Employee employee) {
    return employeeRepository.save(employee);
  }

  @PutMapping("/update/employee/{id}")
  public ResponseEntity<String> updateEmployee(
      @PathVariable int id, @RequestBody Employee employee) {
    employee.setEmployeeId(id);
    Optional<Employee> optionalEmployee = employeeRepository.findById(id);
    if (optionalEmployee.isPresent()) {
      employeeRepository.save(employee);
      return new ResponseEntity<>("Updated employee by id = " + id, HttpStatus.OK);
    } else {
      return new ResponseEntity<>("Failed to update by id = " + id, HttpStatus.NOT_FOUND);
    }
  }
}
