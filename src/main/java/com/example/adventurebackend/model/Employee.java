package com.example.adventurebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

  @Id
  @Column(name="employee_id")

  private String employeeId;
  private String employeeFirstName;
  private String employeeLastName;
  private String employeePhoneNumber;
  private String employeeTitle;


  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeFirstName() {
    return employeeFirstName;
  }

  public void setEmployeeFirstName(String employeeFirstName) {
    this.employeeFirstName = employeeFirstName;
  }

  public String getEmployeeLastName() {
    return employeeLastName;
  }

  public void setEmployeeLastName(String employeeLastName) {
    this.employeeLastName = employeeLastName;
  }

  public String getEmployeePhoneNumber() {
    return employeePhoneNumber;
  }

  public void setEmployeePhoneNumber(String employeePhoneNumber) {
    this.employeePhoneNumber = employeePhoneNumber;
  }

  public String getEmployeeTitle() {
    return employeeTitle;
  }

  public void setEmployeeTitle(String employeeTitle) {
    this.employeeTitle = employeeTitle;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "employeeId='" + employeeId + '\'' +
        ", employeeFirstName='" + employeeFirstName + '\'' +
        ", employeeLastName='" + employeeLastName + '\'' +
        ", employeePhoneNumber='" + employeePhoneNumber + '\'' +
        ", employeeTitle='" + employeeTitle + '\'' +
        '}';
  }
}
