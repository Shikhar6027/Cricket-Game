package com.example.gameofcricket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


@Data
@Builder
@Document(collection="Player")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Player {



@Id
private String id;
private int playerID;
    private String name;
    private int age;
    private String role;
    private int totalRuns;
    private int totalWickets;
    private int totalOversDelivered;
    private int totalBallsFaced;

    private int totalRunsGiven;

    private int teamID;


    private double strikeRate=0;
    private double economy=0;
    private String belongsToCountry;

    Player bowledBy;
//    ArrayList<Player> batsmenWicket=new ArrayList<Player>();


    public void setId(String id) {
        this.id = id;
    }
    public void setTotalOvers(){
        this.totalOversDelivered++;
    }
    public void setTotalWickets(){
        this.totalWickets++;
    }

    public void setTotalWickets(int totalWickets) {
        this.totalWickets +=totalWickets;
    }

    public void setTotalRunsGiven(int runs)
    {
        this.totalRunsGiven+=runs;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns += totalRuns;
    }

    public void setTotalOversDelivered(int totalOversDelivered) {
        this.totalOversDelivered += totalOversDelivered;
    }

    public void setEconomy(double economy) {
        this.economy = economy;
    }

    public void setTotalBallsFaced(int ballsFaced) {
        this.totalBallsFaced += ballsFaced;
    }

    public void setBowledBy(Player bowledBy) {
        this.bowledBy = bowledBy;
    }

    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }

    public void setBatsmenWicket(ArrayList<Player> batsmenWicket) {
        batsmenWicket.addAll(batsmenWicket);
    }

//    public void AddBowledBatsmen(Player player) {
//        this.batsmenWicket.add(player);
//    }
}
