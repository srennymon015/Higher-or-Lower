package main;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player>{


    @Override
    public int compare(Player player1, Player player2) {
        return player2.getScore() - player1.getScore();
    }

}
