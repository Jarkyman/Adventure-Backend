package com.example.adventurebackend.repository;

import com.example.adventurebackend.model.Adventure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdventuresRepository extends JpaRepository<Adventure, String> {}
