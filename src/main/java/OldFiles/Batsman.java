public class Batsman extends Player {
    Batsman(int id)
    {
        this.playerID=id;
    }

    @Override
    public void calculateStrikeRate() {
        int sr= this.runs/Math.max(1,this.ballsFaced) ;
        this.strikeRate=sr;
    }

}
