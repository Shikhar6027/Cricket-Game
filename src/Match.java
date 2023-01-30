import  java.util.*;
import java.lang.*;
public class Match {
    private int numberOfOvers;
    public String team1Name;
     String team2Name;
    Team Team1;
    Team Team2;


    public void setNumberOfOvers(int numberOfOvers)
    {
        this.numberOfOvers=numberOfOvers;
    }
    public void setTeam1Name(String team1Name)
    {
        this.team1Name=team1Name;

    }
    public void setTeam2Name(String team2Name)
    {
        this.team2Name=team2Name;

    }
    Match (int overs ,String name1,String name2)
    {
        this.setNumberOfOvers(overs);
        this.setTeam1Name(name1);
        this.setTeam2Name(name2);
        Team1 = new Team(team1Name,numberOfOvers);
        Team2 = new Team(team2Name,numberOfOvers);
    }


}
