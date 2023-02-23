package com.example.gameofcricket.controller;

import com.example.gameofcricket.model.Tournamnet;
import com.example.gameofcricket.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tournament")
public class TournamentController {
    @Autowired
    private  TournamentService tournamentService;
    @GetMapping("/details")
    public List<Tournamnet> showDetails(){

        return tournamentService.findAll();
    }
}
