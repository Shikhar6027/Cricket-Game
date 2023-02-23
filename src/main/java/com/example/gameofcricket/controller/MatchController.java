package com.example.gameofcricket.controller;

import com.example.gameofcricket.ResponseAndRequest.MatchStartRequest;
import com.example.gameofcricket.model.Innings;
import com.example.gameofcricket.model.Match;
import com.example.gameofcricket.model.Tournamnet;
import com.example.gameofcricket.service.GameService;
import com.example.gameofcricket.service.MatchService;
import com.example.gameofcricket.service.TournamentService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/match")
@Slf4j
public class MatchController {
    @Autowired
    private  MatchService matchService;
    @Autowired
    private TournamentService tournamentService;
    @Autowired
    private GameService gameService;
    @PostMapping("/play")
    public String startMatch(@RequestBody MatchStartRequest attr)
    {

        log.debug(attr.getTeam1Name());
        String team1Name="",team2Name="";
        int numberOfOvers=0;
        try {
            team1Name=attr.getTeam1Name();
            team2Name=attr.getTeam2Name();
            numberOfOvers=attr.getNumberOfOvers();
        }
        catch (Exception ex)
        {
            log.error("Exception when starting match");
        }
        System.out.println(team1Name+" "+team2Name);
         return gameService.simulateGame(team1Name,team2Name,numberOfOvers);
    }

    @GetMapping("/showDetails/{id}")
    public Match showMatchDetails(@PathVariable String id)
    {
        System.out.println(id);
        Optional<Match> match=matchService.showMatchDetails(id);
        if(match.isPresent())
        {
            return match.get();
        }
        else
        {
            System.out.println("Invalid ID");
            return null;
        }
    }
}
