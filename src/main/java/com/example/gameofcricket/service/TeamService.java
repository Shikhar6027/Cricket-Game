package com.example.gameofcricket.service;

import com.example.gameofcricket.model.Player;
import com.example.gameofcricket.model.Team;
import com.example.gameofcricket.repository.TeamRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor

public class TeamService {
    private final TeamRepo teamRepo;

    public void addTeam(ArrayList<Team> team) {
        teamRepo.saveAll(team);
    }

    public Team findByTeamName(String name) {
        return teamRepo.findByName(name);
    }
    public void save(Team team)
    {
        teamRepo.save(team);
    }
}
