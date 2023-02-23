import java.security.PublicKey;
import java.util.*;

public class Tournament {

    static Map<String ,Team> teams = new HashMap<String,Team>();
    public void setTeams () {
        teams.put("MI",new Team("MI"));
        teams.put("CSK",new Team("CSK"));
        teams.put("RCB",new Team("RCB"));
        teams.put("DC",new Team("DC"));
        teams.put("SRH",new Team("SRH"));
        teams.put("RR",new Team("RR"));
        teams.put("PBKS",new Team("PBKS"));
        teams.put("KKR",new Team("KKR"));
        teams.put("LSG",new Team("LSG"));
        teams.put("GT",new Team("GT"));

    }
    public static Void pointsTable()
    {
        System.out.println("Team  M   W   L  P");
        int cnt=0;
        for(Map.Entry<String,Team> t1: teams.entrySet())
        {
            cnt++;
            System.out.println(t1.getValue().TeamName + "    "+ t1.getValue().playedMathes+"   "+t1.getValue().wins+"    "+t1.getValue().lose+"    "+t1.getValue().points);
        }
        System.out.println(teams.size());
        return null;
    }


}
