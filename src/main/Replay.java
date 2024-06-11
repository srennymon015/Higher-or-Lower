package main;

public class Replay {
    private Card card;
    private String guess;
    private String outcome;
    private Card nextCard;

    public Replay(){
        card=null;
        guess="";
        outcome="";
        nextCard=null;

    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public void setNextCard(Card card){this.nextCard=card;}

    public Card getCard() {
        return card;
    }

    public String getGuess() {
        return guess;
    }

    public String getOutcome() {
        return outcome;
    }

    public Card getNextCard() {
        return nextCard;
    }
}
