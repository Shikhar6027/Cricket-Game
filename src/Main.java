import javax.swing.plaf.metal.MetalTabbedPaneUI;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number of overs to be played in match");
        int numOfOvers=parseInt(sc.nextLine());
        System.out.println("Enter First Team Name");
        String Team1Name=sc.nextLine();
        System.out.println("Enter Second Team Name");
        String Team2Name=sc.nextLine();

        System.out.println("**********Toss***********");
        int verdict= (int)(Math.random()*2);
        String TossWinningTeam,TossLosingTeam;
        if(verdict==0){

            TossWinningTeam=Team1Name;
            TossLosingTeam=Team2Name;
        }
        else {
          //  System.out.println(Team2Name +" Won the Toss");
            TossWinningTeam=Team2Name;
            TossLosingTeam=Team1Name;

        }
        System.out.println(TossWinningTeam +" Won the Toss");
        System.out.println("Type your Choice  Bat/Bowl");
        String choice =sc.next();
        Inning Ing1,Ing2;


        if(choice.equals("Bat")) {
            Ing1 = new Inning(numOfOvers, TossWinningTeam, TossLosingTeam);
            Ing2=new Inning(numOfOvers,TossLosingTeam,TossWinningTeam);
            System.out.println("******** "+TossWinningTeam+" team will bat  *******");

        }else {
            Ing1 = new Inning(numOfOvers, TossLosingTeam, TossWinningTeam);
            Ing2 = new Inning(numOfOvers, TossWinningTeam, TossLosingTeam);
            System.out.println("******** "+TossLosingTeam+" team will bat  *******");

        }

        //Ing1.Team1.gameSimulator.playGame();
        Ing1.gameSimulator.playGame();
        Ing1.gameSimulator.display.DisplayStats();
        int totalRuns1=Ing1.gameSimulator.score.runs;
        int totalWickets1=Ing1.gameSimulator.score.wickets;

        System.out.println("Score of "+Ing1.Team1.TeamName+" "+totalRuns1+"/"+totalWickets1);
        System.out.println("******** now next team will bat  *******");
        //Ing1.Team2.gameSimulator.playGame();
        Ing2.gameSimulator.playGame();
        Ing2.gameSimulator.display.DisplayStats();

        int totalRuns2=Ing2.gameSimulator.score.runs;
        int totalWickets2=Ing2.gameSimulator.score.wickets;
        System.out.println("Score of "+Ing2.Team1.TeamName+" "+totalRuns2+"/"+totalWickets2);

        if(totalRuns1>totalRuns2)
        {
            System.out.println(Ing1.Team1.TeamName+" Won the match");
            Ing1.Team1.setPlayedMathes();
            Ing1.Team2.setPlayedMathes();
            Ing1.Team1.setWins();
            Ing1.Team2.setLose();
            Ing1.Team1.setWinPoints();

        }
        else if(totalRuns2>totalRuns1)
        {
            System.out.println(Ing2.Team1.TeamName+" Won the match");
            Ing2.Team1.setPlayedMathes();
            Ing2.Team2.setPlayedMathes();
            Ing2.Team1.setWins();
            Ing2.Team2.setLose();
            Ing2.Team1.setWinPoints();

        }
        else
        {
            System.out.println("match is tied");
            Ing2.Team1.setPlayedMathes();
            Ing2.Team2.setPlayedMathes();
            Ing2.Team1.setTiePoints();
            Ing2.Team2.setTiePoints();
        }




    }
}