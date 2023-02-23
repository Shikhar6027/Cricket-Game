package com.example.gameofcricket.service;

import com.example.gameofcricket.model.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@AllArgsConstructor
public class MatchExecutioner {
    private final TeamService teamService;
    private final TournamentService tournamentService;
    private final PlayerService playerService;

    private String batsmanScore()
    {
        ArrayList<String> hitValue= new ArrayList<String>();

        hitValue.add("1");
        hitValue.add("2");
        hitValue.add("3");
        hitValue.add("4");
        hitValue.add("6");
        hitValue.add("W");
        hitValue.add("Wd");
        hitValue.add("N");

        int index=(int)(Math.random()*8);
        if(index==5)
        {
            index=(int)(Math.random()*8);
        }
        return hitValue.get(index);
    }

    public Innings playGame(String BattingTeamName,String BallingTeamName,int numberOfOvers) {
            ArrayList<Player> playerArrayListBat;
            ArrayList<Player> playerArrayListBall;

            int playerRuns=0,ballsFaced=0,totalRuns=0,playerId=1,wicketCount=0;
        Team batTeam=teamService.findByTeamName(BattingTeamName);
        Team ballTeam=teamService.findByTeamName(BallingTeamName);
        if(batTeam==null || ballTeam==null)
        {
            throw new IllegalArgumentException("Team name is not valid");
        }


        playerArrayListBat=batTeam.getPlayerArrayList();
        playerArrayListBall=ballTeam.getPlayerArrayList();
        System.out.println("Overs Stats of "+BattingTeamName);
        while (numberOfOvers > 0) {
            ArrayList<String> overStats=new ArrayList<String>();
            int bowlerId=(numberOfOvers%5)+7;
            playerArrayListBall.get(bowlerId-1).setTotalOvers();

            for (int i = 1; i <=6; i++) {
                String hitValue = batsmanScore();
                overStats.add(hitValue);
                if(hitValue=="Wd" || hitValue=="N")
                {
                    i--;
                }
                else if (hitValue != "W") {
                    playerRuns+=Integer.parseInt(hitValue);
                    totalRuns+=Integer.parseInt(hitValue);
                    playerArrayListBall.get(bowlerId-1).setTotalRunsGiven(Integer.parseInt(hitValue));;
                    ballsFaced++;
                } else {
                    playerArrayListBat.get(playerId-1).setTotalRuns(playerRuns);
                    playerArrayListBat.get(playerId-1).setTotalBallsFaced(ballsFaced);
                    playerArrayListBat.get(playerId-1).setBowledBy( playerArrayListBall.get(bowlerId-1));
                    playerArrayListBall.get(bowlerId-1).setTotalWickets();
                    playerRuns=0;
                    ballsFaced=0;
                    playerId++;
                    wicketCount++;
                }
                if(wicketCount==10)
                {
                    System.out.println("Team is All out");
                    break;
                }
            }
            if(wicketCount==10)
                break;

            for(String ball:overStats)
            {
                System.out.print(ball+" ");
            }
            System.out.println("");
            numberOfOvers--;
        }
        for(Player player:playerArrayListBat)
        {
            player.setStrikeRate(player.getTotalRuns()*100.0/player.getTotalBallsFaced());

            playerService.setBatPlayerStats(player);
        }
        for(Player player:playerArrayListBall)
        {
            player.setEconomy(player.getTotalRunsGiven()*1.0/player.getTotalOversDelivered());
            playerService.setBallPlayerStats(player);
        }
        Innings inning= Innings.builder()
                .batTeamName(BattingTeamName)
                .ballTeamName(BallingTeamName)
                .runs(totalRuns)
                .wickets(wicketCount)
                .playerArrayListBat(playerArrayListBat)
                .playerArrayListBall(playerArrayListBall)
                .build();
        System.out.println(inning.getBatTeamName()+"  Score "+totalRuns+"/ "+wicketCount);
        return inning;


    }
}
