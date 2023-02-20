package com.example.gameofcricket.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

public class Team {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;



}
