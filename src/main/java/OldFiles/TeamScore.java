public class TeamScore {
    public int runs;
    public int wickets;
    public void setRuns(int runs){
        this.runs=runs;
    }
    public void setWickets(int wickets){
        this.wickets=wickets;
    }
    TeamScore(int runs,int wickets)
    {
        this.setRuns(runs);
        this.setWickets(wickets);
    }
}
