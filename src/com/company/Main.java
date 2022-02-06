package com.company;


import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        DiscardPile discard = new DiscardPile();
        Game game = new Game();
        game.playGame();

    }
}

