package com.example.gameofcricket.service;

import com.example.gameofcricket.model.*;
import com.example.gameofcricket.repository.MatchRepo;
import com.example.gameofcricket.repository.TeamRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MatchService {
    private final MatchRepo matchRepo;
    private final TeamRepo teamRepo;
    private final MatchExecutioner matchExecutioner;


    public Innings playInnings(String team1, String team2, int numberOfOvers) {
        return matchExecutioner.playGame(team1,team2,numberOfOvers);
    }

    public void save(Match match) {
        matchRepo.save(match);
    }

    public Optional<Match> showMatchDetails(String id) {
        return matchRepo.findById(id);
    }



//    public Match findByTeamName(String name) {
//        return teamRepo.findByName(name);
//    }

}
