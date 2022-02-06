package com.company;

import java.util.ArrayList;


public class DiscardPile {
    /**
     *  Fields for DiscardPile class.
     */
    static ArrayList<Card> play;


    /**
     * Constructor for DiscardPile class.
     */
    public DiscardPile(){

        play = new ArrayList<>();
        play.add(Deck.drawCard());


    }

    /**
     * Shows the top card of the discard pile.
     * @return A string detailing the value and color of the top card of the discard pile.
     */
    public static String showTopCard(){
        return play.get(play.size()-1).getColor() + " " + play.get(play.size()-1).getValue();
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

