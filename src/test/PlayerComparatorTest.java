package test;

import main.Player;
import main.PlayerComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerComparatorTest {

    @Test
    public void compareTest() {

        PlayerComparator comparator = new PlayerComparator();

        Player player1 = new Player("Samuel",5);
        Player player2=new Player("Daniel",7);

        Assertions.assertEquals(2,comparator.compare(player1,player2));
    }
}