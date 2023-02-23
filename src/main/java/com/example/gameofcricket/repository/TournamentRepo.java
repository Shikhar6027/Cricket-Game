package com.example.gameofcricket.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.gameofcricket.model.Tournamnet;
import org.springframework.stereotype.Repository;

@Repository

public interface TournamentRepo extends MongoRepository<Tournamnet,String> {
}
