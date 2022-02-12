package com.company;

public class Card {
    /**
     *  Fields for Card class.
     */
    Integer value;
    String color;
    String special;


    /**
     *  Constructor for Card class.
     */
    public Card(int aValue, String aColor){
        this.value = aValue;
        this.color = aColor;
        this.special = null;
    }

    public Card(int aValue,String aColor, String aSpecial){
        this.value = aValue;
        this.color = aColor;
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

    /**
     * Get cards special type.
     * @return special - a String.
     */
    public String getSpecial(){
        return special;
    }
}

