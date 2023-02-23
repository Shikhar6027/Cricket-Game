package com.example.gameofcricket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.service.annotation.GetExchange;

import java.util.ArrayList;
@Data
@Document(collection = "Teams")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Team {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private int teamID;
    private String name;
    private int playedMatches=0;
    private int wins=0;
    private int lose=0;
    private int points=0;

  public void setLose() {
    this.lose++;
  }

  public void setPoints() {
    this.points+=2;
  }

  public void setWins() {
    this.wins++;
  }

  public void setPlayedMatches() {
    this.playedMatches ++;
  }

  private ArrayList<Player> playerArrayList;





}
