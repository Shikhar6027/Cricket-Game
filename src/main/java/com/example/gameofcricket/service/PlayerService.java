package com.example.gameofcricket.service;

import com.example.gameofcricket.model.Player;
import com.example.gameofcricket.repository.PlayerRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor

public class PlayerService {
    private final PlayerRepo playerRepo;
    public void save(Player player)
{
    playerRepo.save(player);
}
    public void save(ArrayList<Player> player) {
//        for(Player plr:player)
//        {
//            playerRepo.save(plr);
//        }
        playerRepo.saveAll(player);
    }

    public void setBatPlayerStats(Player player) {
        Optional<Player> plr=playerRepo.findByPlayerID(player.getPlayerID());
        Player sportsPerson=plr.get();
        sportsPerson.setTotalRuns(player.getTotalRuns());
        sportsPerson.setTotalBallsFaced(player.getTotalBallsFaced());
        double SR=sportsPerson.getTotalRuns()*100.0/sportsPerson.getTotalBallsFaced();
        sportsPerson.setStrikeRate(SR);

       // System.out.println(plr);
        playerRepo.save(sportsPerson);
}
    public void setBallPlayerStats(Player player)
    {
        Optional<Player> plr=playerRepo.findByPlayerID(player.getPlayerID());
        Player sportsPerson=plr.get();
       // System.out.println("1: " + sportsPerson.getName());
        sportsPerson.setTotalWickets(player.getTotalWickets());
        sportsPerson.setTotalRunsGiven(player.getTotalRunsGiven());
        sportsPerson.setTotalOversDelivered(player.getTotalOversDelivered());
//        sportsPerson.setBatsmenWicket(player.getBatsmenWicket());
        double EC=sportsPerson.getTotalRunsGiven()*1.0/(sportsPerson.getTotalOversDelivered());
        sportsPerson.setEconomy(EC);
       // System.out.println("2: " + sportsPerson.getName());

        playerRepo.save(sportsPerson);


    }

    public Optional<Player> findByPlayerId(int playerID) {
    Optional<Player> player=playerRepo.findByPlayerID(playerID);
    return player;
    }
}
