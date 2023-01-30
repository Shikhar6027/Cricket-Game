import java.util.ArrayList;

public class Team {
    private String TeamName;
    private int numberOfOvers;
    TeamScore score;
     int playersLeftToBat=11;
     int totalRuns=0;
    public void setTeamName(String name)
    {
        this.TeamName=name;
    }
    public void setNumberOfOvers(int numberOfOvers)
    {
        this.numberOfOvers=numberOfOvers;
    }
    Team(String name,int numberOfOvers)
    {
        this.setTeamName(name);
        this.setNumberOfOvers(numberOfOvers);
    }
    public String batsmanScore()
    {
        ArrayList<String > hitValue= new ArrayList<String>();

        hitValue.add("1");
        hitValue.add("2");
        hitValue.add("3");
        hitValue.add("4");
        hitValue.add("5");
        hitValue.add("6");
        hitValue.add("W");

        int index=(int)(Math.random()*7);
      //  System.out.println(index);
        return hitValue.get(index);

    }

    public void playGame() {
        while (numberOfOvers > 0) {
            int balls = 6;
            for (int i = 1; i <= balls; i++) {
                String hitValue = batsmanScore();
               // System.out.println(hitValue);
                if (hitValue != "W") {

                    System.out.println("Batsman has scored " + hitValue + " runs");
                    totalRuns+=Integer.parseInt(hitValue);

                } else {
                    System.out.println("Batsman is out");
                    playersLeftToBat--;
                }
                if(playersLeftToBat==0)
                {
                    System.out.println("Team is All out");
                    //System.out.println("Total score of Team " + this.TeamName + " is " + totalRuns);
                    break;

                }

            }
            if(playersLeftToBat==0)
                break;
            numberOfOvers--;
        }
        System.out.println("Innings of team "+this.TeamName+" is over");
        System.out.println("Total score of Team " + this.TeamName + " is " + totalRuns);
        score=new TeamScore(totalRuns,11-playersLeftToBat);
        return;

    }

}
