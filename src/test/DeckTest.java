package test;

import main.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    public void shuffleCardsTest() {
        Deck deck1= new Deck();
        Deck deck2= new Deck();

        deck2.shuffleCards();

        Assertions.assertNotEquals(deck1,deck2);
    }

    @Test
    public void dealCardTest() {
        Deck deck= new Deck();

        Assertions.assertNotNull(deck.dealCard());
    }




    @Test
    public void dealGameCardTest() {
        Deck deck= new Deck(6);

        Assertions.assertNotNull(deck.dealGameCard());
    }


}