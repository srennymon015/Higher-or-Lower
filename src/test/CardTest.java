package test;

import main.Card;
import org.junit.jupiter.api.Assertions;



class CardTest {

    @org.junit.jupiter.api.Test
    public void getSuitTest() {
        Card card = new Card(5,2);
        Assertions.assertEquals(2,card.getSuit());
    }



    @org.junit.jupiter.api.Test
    public void getValueTest() {
        Card card = new Card(5,2);
        Assertions.assertEquals(5,card.getValue());
    }


    @org.junit.jupiter.api.Test
    public void getSuitStringDiamondsTest() {
        Card card = new Card(5,2);
        Assertions.assertEquals("Diamonds",card.getSuitString());
    }

    @org.junit.jupiter.api.Test
    public void getSuitStringSpadesTest() {
        Card card = new Card(5,0);
        Assertions.assertEquals("Spades",card.getSuitString());
    }

    @org.junit.jupiter.api.Test
    public void getSuitStringClubsTest() {
        Card card = new Card(5,3);
        Assertions.assertEquals("Clubs",card.getSuitString());
    }

    @org.junit.jupiter.api.Test
    public void getSuitStringInvalidSuitTest() {
        Card card = new Card(5,8);
        Assertions.assertEquals("Invalid Suit",card.getSuitString());
    }




    @org.junit.jupiter.api.Test
    public void getValueStringAceTest() {
        Card card = new Card(1,2);
        Assertions.assertEquals("Ace",card.getValueString());
    }

    @org.junit.jupiter.api.Test
    public void getValueString2Test() {
        Card card = new Card(2,2);
        Assertions.assertEquals("2",card.getValueString());
    }

    @org.junit.jupiter.api.Test
    public void getValueString3Test() {
        Card card = new Card(3,2);
        Assertions.assertEquals("3",card.getValueString());
    }

    @org.junit.jupiter.api.Test
    public void getValueString4Test() {
        Card card = new Card(4,2);
        Assertions.assertEquals("4",card.getValueString());
    }

    @org.junit.jupiter.api.Test
    public void getValueString5Test() {
        Card card = new Card(5,2);
        Assertions.assertEquals("5",card.getValueString());
    }

    @org.junit.jupiter.api.Test
    public void getValueString6Test() {
        Card card = new Card(6,2);
        Assertions.assertEquals("6",card.getValueString());
    }

    @org.junit.jupiter.api.Test
    public void getValueString7Test() {
        Card card = new Card(7,2);
        Assertions.assertEquals("7",card.getValueString());
    }

    @org.junit.jupiter.api.Test
    public void getValueString8Test() {
        Card card = new Card(8,2);
        Assertions.assertEquals("8",card.getValueString());
    }

    @org.junit.jupiter.api.Test
    public void getValueString9Test() {
        Card card = new Card(9,2);
        Assertions.assertEquals("9",card.getValueString());
    }

    @org.junit.jupiter.api.Test
    public void getValueString10Test() {
        Card card = new Card(10,2);
        Assertions.assertEquals("10",card.getValueString());
    }

    @org.junit.jupiter.api.Test
    public void getValueStringJackTest() {
        Card card = new Card(11,2);
        Assertions.assertEquals("Jack",card.getValueString());
    }

    @org.junit.jupiter.api.Test
    public void getValueStringQueenTest() {
        Card card = new Card(12,2);
        Assertions.assertEquals("Queen",card.getValueString());
    }

    @org.junit.jupiter.api.Test
    public void getValueStringKingTest() {
        Card card = new Card(13,2);
        Assertions.assertEquals("King",card.getValueString());
    }


    @org.junit.jupiter.api.Test
    public void toStringTest() {
        Card card = new Card(5,2);
        Assertions.assertEquals("5 of Diamonds",card.toString());

    }









}