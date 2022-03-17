package com.example.adventurebackend.repository;

import com.example.adventurebackend.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {}
