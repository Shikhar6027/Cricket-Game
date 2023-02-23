package com.example.gameofcricket.ResponseAndRequest;

import lombok.Data;

@Data

public class MatchStartRequest {
   private String team1Name;
   private String team2Name;
   private int numberOfOvers;
}
