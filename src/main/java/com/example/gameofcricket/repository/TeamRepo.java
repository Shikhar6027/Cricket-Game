package com.example.gameofcricket.repository;

import com.example.gameofcricket.model.Player;
import com.example.gameofcricket.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository

public interface TeamRepo extends MongoRepository<Team,String> {
    public Team findByName(String name);
}
