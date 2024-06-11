package test;

import main.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    public void getNameTest() {
        Player player = new Player("Samuel",5);

        Assertions.assertEquals("Samuel",player.getName());
    }

    @Test
    public void getScoreTest() {
        Player player = new Player("Samuel",5);

        Assertions.assertEquals(5,player.getScore());
    }
}