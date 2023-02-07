import java.lang.*;
public class Inning {
   // private int numberOfOvers;
    public String team1Name;
 Helper gameSimulator;


     String team2Name;
     int numberOfOvers;
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
    Inning (int numberOfOvers,String name1,String name2)
    {
       this.setNumberOfOvers(numberOfOvers);
        this.setTeam1Name(name1);
        this.setTeam2Name(name2);
        Team1 = new Team(team1Name);
        Team2 = new Team(team2Name);
     gameSimulator=new Helper(numberOfOvers,team1Name,Team1.playerArrayList,Team2.playerArrayList);

    }


}
