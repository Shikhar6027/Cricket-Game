package com.example.gameofcricket.service;

import com.example.gameofcricket.model.Match;
import com.example.gameofcricket.model.Tournamnet;
import com.example.gameofcricket.repository.TournamentRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class TournamentService {
    @Autowired
    private  TournamentRepo tournamentRepo;
    public void setDetails(Match match) {
        Tournamnet tournamnet=Tournamnet
                .builder()
                .team1Name(match.getWinner())
                .team2Name(match.getLoser())
                .team1Runs(match.getTeam1Runs())
                .team2Runs(match.getTeam2Runs())
                .team1Wickets(match.getTeam1Wickets())
                .team2Wickets(match.getTeam2Wickets())
                .winner(match.getWinner()).build();
        tournamentRepo.save(tournamnet);
    }

    public List<Tournamnet> findAll() {
        return tournamentRepo.findAll();
    }
}
