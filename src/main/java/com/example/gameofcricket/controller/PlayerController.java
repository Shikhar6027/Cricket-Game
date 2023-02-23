package com.example.gameofcricket.controller;

import com.example.gameofcricket.model.Player;
import com.example.gameofcricket.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    PlayerService playerService;
    @PostMapping("/add-one")
    public void addOnePlayer(@RequestBody Player player) {
        playerService.save(player);
    }

    @PostMapping("/add")
    public void addPlayers(@RequestBody ArrayList<Player> player)
    {
        playerService.save(player);
    }
    @GetMapping("/details/{playerID}")
    public Player showPlayerDetails(@PathVariable int playerID)
    {
        Optional<Player> player=playerService.findByPlayerId(playerID);

        if(player.isPresent())
        {
            return player.get();
        }
        else {
            System.out.println();
            return null;

        }
    }

}
