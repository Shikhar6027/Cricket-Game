import java.util.*;

public class Team {

     String TeamName;
     int playedMathes=0;
     int wins=0;
     int lose=0;
     int points=0;
    //int numberOfOvers;


    TeamScore score;
    ArrayList<Player> playerArrayList=new ArrayList<>(11);
    public void setupTeam()
    {
        for(int i=1;i<12;i++)
        {
            Player athlete;


            if(i<=6) {
                athlete = new Batsman(i);
            }
            else
                athlete=new Bowler(i);
            playerArrayList.add(athlete);
        }
    }

    public void setTeamName(String name)
    {
        this.TeamName=name;
    }

    public void setPlayedMathes() {
        this.playedMathes++;
    }

    public void setWins() {
        this.wins++;
    }

    public void setLose() {
        this.lose++;
    }

    public void setWinPoints() {
        this.points+=2;
    }
    public void setTiePoints()
    {
        this.points+=1;
    }

    Team(String name)
    {
        this.setTeamName(name);
        //this.numberOfOvers=numberOfOvers;
        setupTeam();

    }

}
