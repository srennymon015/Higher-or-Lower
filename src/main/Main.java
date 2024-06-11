package main;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class Main {

    public static void main(String[] args) throws IOException {
        menu();
    }

    private static void menu() throws IOException {
        int choice;
        System.out.println("High Low Game");
        System.out.println("1.New Game \n2.Demonstration Mode \n3.Exit Program ");
        System.out.println("Please select an option from the 3 Listed above: ");

        Scanner scan= new Scanner(System.in);

        choice=scan.nextInt();

        if(choice<1&&choice>3){
            System.out.println("Invalid option entered. Please enter a valid option");
            menu();
        }
        else{
            while(choice>=1 && choice <=3){
                if(choice==1){
                    newGame();
                }
                else if(choice==2){
                    demonstrationMode();
                }
                else if(choice==3){
                    System.exit(0);
                }
            }
        }

    }

    private static void newGame() throws IOException {

        System.out.println("New Game");
        System.out.println();

        String response;
        boolean playAgain=true;
        int noOfCards=0;


        Scanner scan = new Scanner(System.in);

        while(playAgain){
            System.out.println("How many cards would you like to play with?? (Choose between 2 and 52 cards)");
            do{
                noOfCards= scan.nextInt();
                if(noOfCards<2 || noOfCards>52){
                    System.out.println("Please choose between 2 and 52 Cards!!:");
                }
            } while(noOfCards<2 || noOfCards>52);

            int score;
            score = playNewGame(noOfCards);
            logScore(score);
            System.out.println("Would you like to play again? Enter Y for Yes or N for No:");
            response = scan.next();
            playAgain= response.equalsIgnoreCase("Y");
        }
        System.out.println("Thank you for Playing!!");
        showTop5ScoresNewGame();
        System.out.println();
        menu();
    }

    private static int playNewGame(int numberOfCards){
        Deck gameDeck = new Deck(numberOfCards);
        Card currentCard;
        Card nextCard;
        int noOfGuesses=0;
        int correctGuesses;
        Replay[] replays =new Replay[52];
        String guess;
        correctGuesses=0;
        currentCard = gameDeck.dealGameCard();
        System.out.println("The First Card is " + currentCard);
        Scanner scan = new Scanner(System.in);

        for(int i =0;i<numberOfCards-1;i++){

            replays[i]=new Replay();
            replays[i].setCard(currentCard);

            System.out.println("Higher(H), Lower(L), or Stick(S)?:");

            do {
                guess = scan.next();
                if (!guess.equals("H") && !guess.equals("L") && !guess.equals("S")) {
                    System.out.println("Please respond with H or L");
                }
            }while(!guess.equals("H") && !guess.equals("L") && !guess.equals("S"));
            replays[i].setGuess(guess);
            noOfGuesses++;


            nextCard = gameDeck.dealGameCard();
            replays[i].setNextCard(nextCard);
            System.out.println("The next card is "+ nextCard);



            if(nextCard.getValue()== currentCard.getValue()){
                replays[i].setOutcome("Same card");
                System.out.println("The value is the same as the previous card");
                System.out.println("You lose");
                break;
            }
            else if(nextCard.getValue()> currentCard.getValue()){
                if(guess.equals("H")){
                    replays[i].setOutcome("Correct");
                    System.out.println("Correct");
                    correctGuesses++;
                }
                else if(guess.equals("S")){
                    replays[i].setOutcome("Stick");
                    System.out.println("You have chosen to stick...");
                    break;
                }
                else{
                    replays[i].setOutcome("Incorrect");
                    System.out.println("Incorrect");
                    break;
                }
            }  else if(nextCard.getValue()< currentCard.getValue()){
                if(guess.equals("L")){
                    replays[i].setOutcome("Correct");
                    System.out.println("Correct");
                    correctGuesses++;
                }
                else if(guess.equals("S")){
                    replays[i].setOutcome("Stick");
                    System.out.println("You have chosen to stick...");
                    break;
                }
                else{
                    replays[i].setOutcome("Incorrect");
                    System.out.println("Incorrect");
                    break;
                }
            }



            currentCard=nextCard;
            System.out.println();
            System.out.println("The card is "+ currentCard);

        }

        System.out.println();
        if(correctGuesses==numberOfCards-1){
            System.out.println("Well done!! You have guessed all cards correctly!!");
            System.out.println("Score:" + correctGuesses);
            System.out.println();
        }
        System.out.println("Game Over");
        System.out.println("Score:" + correctGuesses);
        System.out.println();

        System.out.println("Would you like to see a replay?? Enter Y for yes or N for No ");
        String replayResponse= scan.next();
        boolean replay=replayResponse.equalsIgnoreCase("Y");
        if(replay){
            replay(replays,noOfGuesses);
        }

        return correctGuesses;

    }





    private static void demonstrationMode() throws IOException {
        System.out.println("Demonstration Mode");
        System.out.println();

        boolean playAgain=true;

        Scanner scan = new Scanner(System.in);

        while(playAgain){
            int score;
            score = playDemonstrationMode();
            logDemonstrationScore(score);
            System.out.println("Would you like to see another demonstration? Enter Y for Yes or N for No:");
            String response = scan.next();
            playAgain= response.equalsIgnoreCase("Y");
        }
        System.out.println("Thank you for watching the demonstaration!!");
        System.out.println();
        showTop5ScoresDemonstrationMode();
        menu();



    }

    private static int playDemonstrationMode() {
        Deck deck = new Deck();
        Random choices= new Random();
        Card currentCard;
        Card nextCard;
        int correctGuesses;
        int computerChoice;
        String guess="";
        deck.shuffleCards();
        correctGuesses=0;
        currentCard = deck.dealCard();
        System.out.println("The First Card is " + currentCard);

        for(int i=0; i<52;i++){
            computerChoice= choices.nextInt(2);
            if(computerChoice==0){
                guess="H";
                System.out.println("The computer chose Higher");
            }
            else if(computerChoice==1){
                guess="L";
                System.out.println("The computer chose Lower");
            }

            System.out.println("Press enter to continue");
            try{System.in.read();}
            catch(Exception e){}


            nextCard = deck.dealCard();
            System.out.println("The next card is "+ nextCard);

            if(nextCard.getValue()== currentCard.getValue()){
                System.out.println("The value is the same as the previous card");
                System.out.println("Computer loses");
                break;
            }
            else if(nextCard.getValue()> currentCard.getValue()){
                if(guess.equals("H")){
                    System.out.println("Correct");
                    correctGuesses++;
                }
                else{
                    System.out.println("Incorrect");
                    System.out.println("Computer loses");
                    break;
                }
            }  else if(nextCard.getValue()< currentCard.getValue()){
                if(guess.equals("L")){
                    System.out.println("Correct");
                    correctGuesses++;
                }
                else{
                    System.out.println("Incorrect");
                    System.out.println("Computer loses");
                    break;
                }
            }

            currentCard=nextCard;
            System.out.println();
            System.out.println("The card is "+ currentCard);

        }

        if(correctGuesses==52){
            System.out.println("Computer has guessed all the cards correctly");
        }

        System.out.println();
        System.out.println("Game Over");
        System.out.println("Score:" + correctGuesses);
        System.out.println();


        return correctGuesses;

    }

    private static void logDemonstrationScore(int score) throws IOException {
        String name= "Computer";

        try
        {
            File f=new File("DemonstrationHighScoreTable.txt");
            PrintWriter pw=new PrintWriter(new FileOutputStream(f,true));
            pw.append(name + ", " + score + "\n");
            pw.close();
        }
        catch(Exception e){}

        sortDemonstrationHighScoreTable();

    }
    private static void sortDemonstrationHighScoreTable() throws IOException{
        BufferedReader reader1 = new BufferedReader(new FileReader("DemonstrationHighScoreTable.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("DemonstrationHighScoreTable.txt"));


        int noOfRecords=0;

        String currentLine=reader1.readLine();

        while(currentLine != null){
            noOfRecords++;
            currentLine = reader1.readLine();
        }

        Player[] players=new Player[noOfRecords];

        currentLine= reader2.readLine();

        for(int i=0;i<players.length;i++ ){
            String[] playerDetails = currentLine.split(", ");
            String name=playerDetails[0];
            int score= Integer.valueOf(playerDetails[1]);

            players[i]= new Player(name,score);

            currentLine = reader2.readLine();

        }

        Arrays.sort(players, new PlayerComparator());

        BufferedWriter writer = new BufferedWriter(new FileWriter("DemonstrationHighScoreTable.txt"));

        for (Player player : players) {
            writer.write(player.getName());
            writer.write(", "+player.getScore());
            writer.newLine();
        }

        reader1.close();
        reader2.close();
        writer.close();
    }

    private static void logScore(int score) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name= scan.next();

        try
        {
            File f=new File("HighScoreTable.txt");
            PrintWriter pw=new PrintWriter(new FileOutputStream(f,true));
            pw.append(name + ", " + score + "\n");
            pw.close();
        }
        catch(Exception e){}

        sortHighScoreTable();
    }

    private static void sortHighScoreTable() throws IOException{
        BufferedReader reader1 = new BufferedReader(new FileReader("HighScoreTable.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("HighScoreTable.txt"));


        int noOfRecords=0;

        String currentLine=reader1.readLine();

        while(currentLine != null){
            noOfRecords++;
            currentLine = reader1.readLine();
        }

        Player[] players=new Player[noOfRecords];

        currentLine= reader2.readLine();

        for(int i=0;i<players.length;i++ ){
            String[] playerDetails = currentLine.split(", ");
            String name=playerDetails[0];
            int score= Integer.valueOf(playerDetails[1]);

            players[i]= new Player(name,score);

            currentLine = reader2.readLine();

        }

        Arrays.sort(players, new PlayerComparator());

        BufferedWriter writer = new BufferedWriter(new FileWriter("HighScoreTable.txt"));

        for (Player player : players) {
            writer.write(player.getName());
            writer.write(", "+player.getScore());
            writer.newLine();
        }

        reader1.close();
        reader2.close();
        writer.close();
    }

    private static void showTop5ScoresNewGame() throws IOException{
        Player[] players = new Player[5];
        System.out.println("TOP 5 SCORES");
        System.out.println("PLAYER  SCORE");
        BufferedReader reader = new BufferedReader(new FileReader("HighScoreTable.txt"));
        String currentLine= reader.readLine();
        for(int i =0; i<players.length;i++){
            String[] playerDetails = currentLine.split(", ");
            String name=playerDetails[0];
            int score= Integer.valueOf(playerDetails[1]);

            players[i]= new Player(name,score);

            currentLine = reader.readLine();
        }

        for (Player player : players) {
            System.out.println(player.getName()+ "   "+ player.getScore());
        }
        System.out.println();
    }

    private static void showTop5ScoresDemonstrationMode() throws IOException{
        Player[] players = new Player[5];
        System.out.println("TOP 5 SCORES");
        System.out.println("PLAYER  SCORE");
        BufferedReader reader = new BufferedReader(new FileReader("DemonstrationHighScoreTable.txt"));
        String currentLine= reader.readLine();
        for(int i =0; i<players.length;i++){
            String[] playerDetails = currentLine.split(", ");
            String name=playerDetails[0];
            int score= Integer.valueOf(playerDetails[1]);

            players[i]= new Player(name,score);

            currentLine = reader.readLine();
        }

        for (Player player : players) {
            System.out.println(player.getName()+ "   "+ player.getScore());
        }
        System.out.println();
    }

    private static void replay(Replay[] replay,int noOfCards){
        for(int i =0; i<noOfCards;i++){
           if(replay[i].equals(null)){
               break;
           }
           else{
               System.out.println("Card: " + replay[i].getCard());
               System.out.println("Your Guess: " + replay[i].getGuess());
               System.out.println("Outcome: " + replay[i].getOutcome());
               System.out.println("Next card was " + replay[i].getNextCard());
               System.out.println("Press enter to continue");
               try{System.in.read();}
               catch(Exception e){}

           }


        }
    }


}
