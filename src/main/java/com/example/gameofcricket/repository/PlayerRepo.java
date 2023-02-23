package com.example.gameofcricket.repository;

import com.example.gameofcricket.model.Player;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface PlayerRepo extends MongoRepository<Player,String> {

    Optional<Player> findByPlayerID(Integer playerID);
}
