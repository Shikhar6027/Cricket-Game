import java.util.ArrayList;

public abstract class Player {
    int playerID;
    int runs=0;
    int ballsFaced=0;
    int wicketsTaken=0;
    int oversDelivered=0;
    int strikeRate=0;
    int economy=0;
    int runsGiven=0;
    Player BoweledBy;
    ArrayList<Player> BatsmenWicket=new ArrayList<Player>();

    public void calculateStrikeRate()
    {
        return ;
    }
    public void calculateEconomy()
    {
        return;
    }
    public void setRuns(int runs)
    {
        this.runs=runs;
    }


    public void setBoweledBy(Player plr) {
        BoweledBy =plr;
    }

    public void setBallsFaced(int ballsFaced) {
        this.ballsFaced = ballsFaced;
    }
    public void updateOversDelivered()
    {
        (this.oversDelivered)++;
    }
    public void AddAddBowledBatsmen(Player plr)
    {
        return;
    }
}
