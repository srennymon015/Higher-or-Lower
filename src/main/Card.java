package main;

public class Card {
    public final static int SPADES = 0;
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;


    private final int suit;
    private final int value;


    public Card(int cardValue, int cardSuit) {
        value=cardValue;
        suit=cardSuit;
    }

    public int getSuit(){
        return suit;
    }

    public int getValue(){
        return value;
    }

    public String getSuitString(){
        switch(suit){
            case SPADES:
                return "Spades";
            case HEARTS:
                return "Hearts";
            case DIAMONDS:
                return "Diamonds";
            case CLUBS:
                return "Clubs";
            default:
                return "Invalid Suit";
        }

    }

    public String getValueString(){
        switch(value) {
            case 1:
                return "Ace";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            default:
                return "King";
        }
    }

    public String toString(){
        return getValueString()+ " of " + getSuitString();
    }


}

