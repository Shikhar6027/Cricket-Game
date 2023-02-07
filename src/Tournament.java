import java.security.PublicKey;
import java.util.ArrayList;

public class Tournament {

    ArrayList<Team> teams = new ArrayList<>();
    public void setTeams () {
        teams.add(new Team("MI  "));
        teams.add(new Team("CSK "));
        teams.add(new Team("RCB "));
        teams.add(new Team("DC  "));
        teams.add(new Team("SRH "));
        teams.add(new Team("RR  "));
        teams.add(new Team("PBKS"));
        teams.add(new Team("KKR "));
        teams.add(new Team("LSG "));
        teams.add(new Team("GT  "));

    }
    public Void pointsTable()
    {
        System.out.println("Team     M      W      L      P");
        for(Team t1:teams)
        {
            System.out.println(t1.TeamName + "    "+ t1.playedMathes+"   "+t1.wins+"    "+t1.lose+"    "+t1.points);
        }
        return null;
    }


}
