package com.example.adventurebackend.controller;

import com.example.adventurebackend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

  @Autowired
  BookingRepository bookingRepository;
}
