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


        Match m1=new Match(numOfOvers,Team1Name,Team2Name);
        System.out.println("******** First team will bat  *******");
        m1.Team1.playGame();
        System.out.println("******** now next team will bat  *******");
        m1.Team2.playGame();
        System.out.println(m1.team1Name+ "  "+m1.Team1.score.runs);
        System.out.println(m1.team2Name+"  "+m1.Team2.score.runs);
        if((m1.Team1.score.runs) > (m1.Team2.score.runs))
        {
            System.out.print(m1.team1Name);
        }
        else if((m1.Team1.score.runs) < (m1.Team2.score.runs))
            System.out.print(m1.team2Name);
        else
        {
            System.out.println("Match is tied");
            return;
        }
       System.out.println(" Won the match");
//        System.out.println(m1.Team2.TeamName);
//        System.out.println(m1.Team1.TeamName);

    }
}