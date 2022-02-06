package com.company;
import java.util.ArrayList;
import java.util.Collections;

public class Deck{
    /**
     * Fields for Deck class.
     */
     static ArrayList<Card> deck;

    /**
     *  Constructor for Deck class.
     *  Uses generate deck to add 9 cards of each color, from 0 to 9, twice and then shuffles it.
     */
    public Deck() {

        deck = new ArrayList<>();

        generateDeck("Yellow");
        generateDeck("Blue");
        generateDeck("Red");
        generateDeck("Green");
        generateDeck("Yellow");
        generateDeck("Blue");
        generateDeck("Red");
        generateDeck("Green");

        shuffle();
    }

    /**
     * Adds a card of number i and of color aColor to the deck when it is instantiated.
    **/
    private void generateDeck(String aColor ){
        for(int i=0; i<10; i++){
            deck.add(new Card(i, aColor));
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    /**
     *  Prints out the color and number of the card at index in the deck.
     */

    public  String get(int index){
        return deck.get(index).getColor() + " " + deck.get(index).getValue();
    }

    /**
     *  Takes a card and adds it to a temp variable, then removes it from the deck.
     *  Used to add cards to player hands.
     * @return The card at index 0.
     */
    public static Card drawCard() {
        Card temp = null;
        try {
            temp = deck.get(0);
            deck.remove(0);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("The draw pile is empty, what you have is what you've got!");
        }
        return temp;
    }

}
