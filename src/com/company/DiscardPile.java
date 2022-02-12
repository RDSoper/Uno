package com.company;

import java.util.ArrayList;


public class DiscardPile {
    /**
     *  Fields for DiscardPile class.
     */
    static ArrayList<Card> play;


    /**
     * Constructor for DiscardPile class. Will put the drawn card on the bottom of the deck and replace it with another
     * from the top if it is a special card.
     */
    public DiscardPile(){
        play = new ArrayList<>();
        play.add(Deck.drawCard());
        while(!(play.get(0).getSpecial()==null)){
            Deck.deck.add(play.get(0));
            play.remove(0);
            play.add(Deck.drawCard());
        }
    }

    /**
     * Shows the top card of the discard pile.
     * @return A string detailing the value and color of the top card of the discard pile.
     */
    public static String showTopCard(){
        String topCard = "";
        if (play.get(play.size() - 1).getSpecial() == null) {
            topCard = "\nThe top card is " + play.get(play.size() - 1).getColor() + " "
                      + play.get(play.size() - 1).getValue() + "\n";
        } else {
            topCard = "\nThe top card is " + play.get(play.size() - 1).getColor() + " "
                      + play.get(play.size() - 1).getSpecial() + "\n";
        }

        return topCard;
    }

    /**
     * Gets the value.
     * @return Value - the value of the top card of the discard pile.
     */
    public static int getValue(){
        return play.get(play.size()-1).getValue();
    }

    /**
     * Gets the color.
     * @return color - the colour of the top card of the discard pile.
     */
    public static String getColor(){
        return play.get(play.size()-1).getColor();
    }
}

