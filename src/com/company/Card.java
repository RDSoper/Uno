package com.company;

public class Card {
    /**
     *  Fields for Card class.
     */
    int value;
    String color;
    String special;

    /**
     *  Constructor for Card class.
     */
    public Card(int aValue, String aColor){
        this.value = aValue;
        this.color = aColor;
    }

    public Card (String aColour, String aSpecial){
        this.color = aColour;
        this.special = aSpecial;
    }

    /**
     * Get cards value.
     * @return value - an int.
     */
    public int getValue(){
        return value;
    }

    /**
     * Get cards color.
     * @return color - a String.
     */
    public String getColor(){
        return color;
    }
}
