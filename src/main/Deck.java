package main;

public class Deck {
    private Card[] deck;
    private Card[] gameDeck;
    private int usedCards;


    public Deck(){
        deck = new Card[52];

        int cardCount=0;
        for(int suit =0;suit<4;suit++){
            for(int value=1; value<=13; value++){
                deck[cardCount++] =new Card(value,suit);
            }
        }


        usedCards=0;
    }

    public Deck(int numberOfCards){
        deck = new Card[52];

        int cardCount=0;
        for(int suit =0;suit<=3;suit++){
            for(int value=1; value<=13; value++){
                deck[cardCount++] =new Card(value,suit);
            }
        }

        shuffleCards();

        gameDeck= new Card[numberOfCards];

        for(int i=0;i< gameDeck.length;i++){
            gameDeck[i]=deck[i];
        }


        usedCards=0;
    }

    public void shuffleCards(){
        for(int i=deck.length-1;i>0;i--){
            int random=(int)(Math.random()*(i+1));
            Card temp=deck[i];
            deck[i]=deck[random];
            deck[random]=temp;
        }
        usedCards=0;
    }


    public Card dealCard(){
        return deck[usedCards++];
    }

    public Card dealGameCard(){
        return gameDeck[usedCards++];
    }

}

