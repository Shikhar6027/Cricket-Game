package com.example.gameofcricket.repository;

import com.example.gameofcricket.model.Match;
import com.example.gameofcricket.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MatchRepo extends MongoRepository<Match,String> {



}
