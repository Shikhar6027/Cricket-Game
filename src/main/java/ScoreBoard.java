import java.util.ArrayList;

public class ScoreBoard {
    ArrayList<Player> playerArrayListBat=new ArrayList<Player>();
    ArrayList<Player> playerArrayListBall=new ArrayList<Player>();
    TeamScore BatTeamScore;

    public ScoreBoard(ArrayList<Player> playerArrayListBat, ArrayList<Player> playerArrayListBall,TeamScore batTeamScore) {
        this.playerArrayListBat = playerArrayListBat;
        this.playerArrayListBall = playerArrayListBall;
        this.BatTeamScore=batTeamScore;
    }
    public void DisplayStats()
    {
        System.out.println("Stats of Batting Team");
        System.out.println("PlayerID      Runs       Balls     WicketBy        SR");
        for(Player plr:playerArrayListBat)
        {
            plr.calculateStrikeRate();
            System.out.println(plr.playerID+"         "+plr.runs+"         "+plr.ballsFaced + "        "+plr.BoweledBy+"            "+plr.strikeRate);
        }
        System.out.println("Stats of Balling Team");
        System.out.println("BowlerId         Overs      Wickets       Runs        Eco");
        for(Player plr:playerArrayListBall)
        {
            plr.calculateEconomy();
            System.out.println(plr.playerID+"               "+plr.oversDelivered+"               "+plr.wicketsTaken+"                "+plr.runsGiven + "          "+plr.economy);

        }

    }
}
