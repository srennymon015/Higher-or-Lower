package main;

public class Player {
    private String name;
    private int score;

    public Player(String playerName,int playerScore){
        this.name=playerName;
        this.score=playerScore;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

}
