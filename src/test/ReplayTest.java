package test;

import main.Card;
import main.Replay;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReplayTest {

    @Test
    public void setCardTest() {
        Card card= new Card(5,1);
        Replay replay = new Replay();

        replay.setCard(card);

        Assertions.assertEquals("5 of Hearts",replay.getCard().toString());

    }

    @Test
    public void setGuessTest() {
        Replay replay = new Replay();

        replay.setGuess("H");

        Assertions.assertEquals("H",replay.getGuess());
    }

    @Test
    public void setOutcomeTest() {
        Replay replay = new Replay();

        replay.setOutcome("Correct");

        Assertions.assertEquals("Correct",replay.getOutcome());
    }

    @Test
    public void setNextCardTest() {
        Card card= new Card(5,1);
        Replay replay = new Replay();

        replay.setNextCard(card);

        Assertions.assertEquals("5 of Hearts",replay.getNextCard().toString());

    }

    @Test
    public void getCardTest() {
        Card card= new Card(5,1);
        Replay replay = new Replay();

        replay.setCard(card);

        Assertions.assertEquals("5 of Hearts",replay.getCard().toString());
    }

    @Test
    public void getGuessTest() {
        Replay replay = new Replay();

        replay.setGuess("H");

        Assertions.assertEquals("H",replay.getGuess());
    }

    @Test
    public void getOutcomeTest() {
        Replay replay = new Replay();

        replay.setOutcome("Correct");

        Assertions.assertEquals("Correct",replay.getOutcome());
    }

    @Test
    public void getNextCardTest() {
        Card card= new Card(5,1);
        Replay replay = new Replay();

        replay.setNextCard(card);

        Assertions.assertEquals("5 of Hearts",replay.getNextCard().toString());
    }
}