package com.example.gameofcricket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data

@Document(collection = "Tournament")
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Tournamnet {
@Id
String id;
    private String team1Name;
    private int team1Runs;
    private int team1Wickets;
    private String team2Name;
    private int team2Runs;
    private int team2Wickets;
    private String winner;
}
