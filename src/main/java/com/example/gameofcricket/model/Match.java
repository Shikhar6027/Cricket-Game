package com.example.gameofcricket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Document(collection = "Match")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Match {
    @Id
    private String id;
    private String team1Name;
    private int team1Runs;
    private int team1Wickets;
    private String team2Name;
    private int team2Runs;
    private int team2Wickets;

    private String winner;
    private String loser;
    private ArrayList<Player> team1PlayerArrayListBat;
   private ArrayList<Player> team1PlayerArrayListBall;
  private   ArrayList<Player> team2PlayerArrayListBat;
   private ArrayList<Player> team2PlayerArrayListBall;

}
