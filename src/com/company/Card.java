package com.company;

public class Card {
    /**
     *  Fields for Card class.
     */
    int value;
    String color;

    /**
     *  Constructor for Card class.
     */
    public Card(int aValue, String aColor){
        this.value = aValue;
        this.color = aColor;
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
