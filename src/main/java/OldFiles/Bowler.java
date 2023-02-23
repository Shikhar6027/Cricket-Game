import java.util.ArrayList;

public class Bowler extends Player {
    public Bowler(int id) {
        this.playerID=id;
    }

    @Override
    public void calculateEconomy() {
        this.economy=this.runsGiven/Math.max(this.oversDelivered,1);
    }
    public void AddBowledBatsmen(Player plr)
    {
        BatsmenWicket.add(plr);
    }
}
