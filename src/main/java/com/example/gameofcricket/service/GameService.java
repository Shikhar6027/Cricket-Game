package com.example.gameofcricket.service;

import com.example.gameofcricket.model.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class GameService {
    @Autowired
    MatchService matchService;
    TournamentService tournamentService;
    TeamService teamService;
    public String simulateGame(String Team1Name, String Team2Name, int numberOfOvers) {
        int verdict = (int) (Math.random() * 2);
        String TossWinningTeam, TossLosingTeam;
        if (verdict == 0) {
            TossWinningTeam = Team1Name;
            TossLosingTeam = Team2Name;
        } else {
            TossWinningTeam = Team2Name;
            TossLosingTeam = Team1Name;

        }
        System.out.println(TossWinningTeam + " Won the Toss");


        Innings inning1 = matchService.playInnings(TossWinningTeam, TossLosingTeam, numberOfOvers);
        Innings inning2 = matchService.playInnings(TossLosingTeam, TossWinningTeam, numberOfOvers);
        String winner, loser;
        if (inning1.getRuns() > inning2.getRuns()) {
            winner = TossWinningTeam;
            loser = TossLosingTeam;
        } else {
            loser = TossWinningTeam;
            winner = TossLosingTeam;
        }
        Team winningTeam =teamService.findByTeamName(winner);
        Team losingTeam =teamService.findByTeamName(loser);
        //System.out.println(winningTeam);
        //System.out.println(losingTeam);
        winningTeam.setWins();
        winningTeam.setPoints();
        winningTeam.setPlayedMatches();

//        System.out.println(inning1);
//        System.out.println(inning2);
        losingTeam.setLose();
        losingTeam.setPlayedMatches();
        teamService.save(winningTeam);
        teamService.save(losingTeam);
        Match match = Match.builder()
                .team1Name(inning1.getBatTeamName())
                .team1Runs(inning1.getRuns())
                .team1Wickets(inning1.getWickets())
                .team2Name(inning2.getBatTeamName())
                .team2Runs(inning2.getRuns())
                .team2Wickets(inning2.getWickets())
                .team1PlayerArrayListBat(inning1.getPlayerArrayListBat())
                .team1PlayerArrayListBall(inning1.getPlayerArrayListBall())
                .team2PlayerArrayListBat(inning2.getPlayerArrayListBat())
                .team2PlayerArrayListBall(inning2.getPlayerArrayListBall())
                .winner(winner)
                .loser(loser)
                .build();
        //System.out.println(match.getTeam1PlayerArrayListBall());
        matchService.save(match);
        System.out.println("match Saved");
        tournamentService.setDetails(match);
        return winningTeam.getName() +" Won the match ";
    }
}
