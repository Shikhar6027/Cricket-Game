package com.example.gameofcricket.controller;

import com.example.gameofcricket.model.Team;
import com.example.gameofcricket.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private  TeamService teamService;

    @PostMapping("/add")
     public void addTeam(@RequestBody ArrayList<Team>team){
        teamService.addTeam(team);

    }
}
