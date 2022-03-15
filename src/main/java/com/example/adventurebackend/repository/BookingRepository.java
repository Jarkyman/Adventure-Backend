package com.example.adventurebackend.repository;

import com.example.adventurebackend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, String> {}
