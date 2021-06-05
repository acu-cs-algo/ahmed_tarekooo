package cardgame2;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner; 

public class CardMain {

    public static void main(String[] args) throws IOException {
       System.out.println();
       System.out.println("               CARD GUESSING GAME              ");
       System.out.println("                 by Sean Mysell                ");
       System.out.println("-----------------------------------------------");
       System.out.println("HOW TO PLAY: Enter values as prompted and guess");
       System.out.println("cards with the syntax (e.g. Ace of Spades, 2 of");
       System.out.println("Clubs)");
       System.out.println("-----------------------------------------------");
       
       Scanner in = new Scanner(System.in);
       boolean go = false;
       
       do {
       go = false;    
       CardPicker picker = new CardPicker();
       CardGenerator generator = new CardGenerator();
       
       picker.setNumCards();    
       picker.setNumGuesses();
       System.out.println("There are " + picker.getNumCards() + " cards.");
       System.out.println("You have " + picker.getNumGuesses() + " guesses.");
       System.out.println();
       String[] cards = generator.getCards(picker.getNumCards());       
       picker.guessCards(cards);
       picker.getScore();
                         System.out.println("Play Again? Y or N");
       String yesOrNo = in.next();
       
       if (yesOrNo.equals("Y") ||
           yesOrNo.equals("y") ||
           yesOrNo.equals("yes"))
        {
           go = true;
           System.out.println("\n");
           System.out.print("~~~~~~~NEW GAME~~~~~~");
           System.out.println("\n\n");
        }
       
       }
       while (go == true);
        
    }
}