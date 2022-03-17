package com.example.adventurebackend.controller;


import com.example.adventurebackend.model.Activity;
import com.example.adventurebackend.repository.ActivityRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.Statement;


@SpringBootTest
public class JPATestSetup {

  @Autowired
  ActivityRepository activityRepository;



  //@Author: Jens
  public void setUpJPA() {

    System.out.println("WWWWWWWWWWWWWWWWW" + activityRepository);
    try {


      Connection connection = (Connection) activityRepository;
      System.out.println("xxxxxxxxxxxxx" + activityRepository);
      Statement SQLstatementTest = connection.createStatement();
      // start transaction
      connection.setAutoCommit(false);

      //NOTE UserRepositoryImplTest Start#
      SQLstatementTest.addBatch("DELETE FROM `activity` WHERE (`activity_title` = 'Test-Create-Activity');\n");
      // SQLstatementTest.addBatch("DELETE FROM `users` WHERE (`user_email` = 'EmailAlreadyExisting@AlphaSolutions.dk');\n");
      // SQLstatementTest.addBatch("DELETE FROM `users` WHERE (`user_email` = 'validateUser@AlphaSolutions.dk');\n");
      //NOTE is Use to Test: public void createUser_UserEmailAlreadyExisting_ShouldThrowUserErrorMessageException()
      //  SQLstatementTest.addBatch("INSERT INTO `users` (`user_email`, `user_password`, `user_username`) VALUES ('EmailAlreadyExisting@AlphaSolutions.dk', '1234', 'Yes Test');\n");
      //NOTE: Is use to Test: public void validateUser_EmailDoesNotExisting_ShouldThrowUserErrorMessageException()
      // SQLstatementTest.addBatch("INSERT INTO `users` (`user_email`, `user_password`, `user_username`) VALUES ('validateUser@AlphaSolutions.dk', '1234', 'Yes Test');\n");
      //NOTE UserRepositoryImplTest Slut#

      SQLstatementTest.executeBatch();

      connection.commit();

    } catch (Exception e) {
      System.out.println("Fail in JDBCTestSetup - setup");
      System.out.println(e.getMessage());
    }
  }
}

