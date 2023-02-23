package com.example.gameofcricket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
@Data
@Getter
@Setter
@Builder
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)

 public class  Innings {
    //private Long id;
    private int runs;
    private int wickets;
    private String batTeamName;
    private String ballTeamName;
    private ArrayList<Player> playerArrayListBat=new ArrayList<Player>();
    private ArrayList<Player> playerArrayListBall=new ArrayList<Player>();

}
