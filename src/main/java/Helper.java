import java.util.ArrayList;

public class Helper {
    private int numberOfOvers;
    ArrayList<Player> playerArrayListBat=new ArrayList<Player>();
    ArrayList<Player> playerArrayListBall=new ArrayList<Player>();
    ScoreBoard display;

    int totalRuns=0;
    int wicketCount=0;
    int ballsFaced=0;
    int ballsDelivered=0;
    String TeamName;
    TeamScore score;
    int playerRuns=0,playerId=1;

    public Helper(int numberOfOvers,String TeamName,ArrayList<Player> playerArrayListBat,ArrayList<Player> playerArrayListBall) {
        this.numberOfOvers = numberOfOvers;
        this.TeamName=TeamName;
        this.playerArrayListBall=playerArrayListBall;
        this.playerArrayListBat=playerArrayListBat;

    }

//    public void setNumberOfOvers(int numberOfOvers)
//    {
//        this.numberOfOvers=numberOfOvers;
//    }
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
        hitValue.add("Wd");
        hitValue.add("N");

        int index=(int)(Math.random()*9);
        //  System.out.println(index);
        return hitValue.get(index);

    }

    public void playGame() {
        while (numberOfOvers > 0) {
            ArrayList<String> overStats=new ArrayList<String>();
            int balls = 6,bowlerId=(numberOfOvers%5)+7;
            playerArrayListBall.get(bowlerId-1).updateOversDelivered();

            for (int i = 1; i <= balls; i++) {

                String hitValue = batsmanScore();
                overStats.add(hitValue);
                // System.out.println(hitValue);
                if(hitValue=="Wd" || hitValue=="N")
                {//System.out.println(hitValue);
                    i--;
                }
                else if (hitValue != "W") {
                    //System.out.println("Batsman has scored " + hitValue + " runs");
                    playerRuns+=Integer.parseInt(hitValue);
                    totalRuns+=Integer.parseInt(hitValue);
                    playerArrayListBall.get(bowlerId-1).runsGiven+=Integer.parseInt(hitValue);
                    ballsFaced++;

                } else {
                    playerArrayListBat.get(playerId-1).setRuns(playerRuns);
                    playerArrayListBat.get(playerId-1).setBallsFaced(ballsFaced);
                    playerArrayListBat.get(playerId-1).setBoweledBy( playerArrayListBall.get(bowlerId-1));
                    playerArrayListBall.get(bowlerId-1).AddAddBowledBatsmen(playerArrayListBat.get(playerId-1));
                    playerArrayListBall.get(bowlerId-1).wicketsTaken++;
                    playerRuns=0;
                    ballsFaced=0;
                    playerId++;
                    //System.out.println("Batsman is out");
                    wicketCount++;
                }
                if(wicketCount==10)
                {
                    System.out.println("Team is All out");
                    //System.out.println("Total score of Team " + this.TeamName + " is " + totalRuns);
                    break;
                }
            }
            if(wicketCount==10)
                break;
            for(String ball:overStats)
            {
                System.out.print(ball+" ");
            }
            System.out.println("");
            numberOfOvers--;
        }
        score=new TeamScore(totalRuns,wicketCount);
        display=new ScoreBoard(playerArrayListBat,playerArrayListBall,score);

//        System.out.println("Innings of team "+this.TeamName+" is over");
//        System.out.println("Total score of Team " + this.TeamName + " is " + totalRuns);

        return;



    }

}
