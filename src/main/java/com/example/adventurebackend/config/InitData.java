package com.example.adventurebackend.config;

import com.example.adventurebackend.repository.AdventuresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class InitData implements CommandLineRunner {

    @Autowired
    AdventuresRepository adventuresRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
