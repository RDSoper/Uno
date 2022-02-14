package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Scanner sc;
    static ArrayList<Player> player;
    static DiscardPile discardPile;
    static Deck deck;

    public Game() {
        this.sc = new Scanner(System.in);
        deck = new Deck();
        player = new ArrayList<>();
        discardPile = new DiscardPile();

    }

    public Player getPlayer(int i){
        return player.get(i);
    }

    public void numberOfPlayers(){
        System.out.println("How many players are playing uno? Number between 2 and 10");
        int players;
        players = sc.nextInt();
        for(int i =0; i<players;i++ ){
            player.add(new Player(i));
            System.out.println("Player "+(player.get(i).getPlayerNumber())+" added.");
        }
    }
    public void reverseTurn(){

        System.out.println("\nTurn order reversed.");
        Collections.reverse(Game.player);
        /*
        Player temp;
        int j = Game.player.size();
        for(int i = 0; i< Game.player.size()/2; i++) {
            temp = Game.player.get(i);
            Game.player.add(i, Game.player.get(j - i - 1));
            Game.player.remove(i + 1);
            Game.player.add(j - i - 1, temp);
            Game.player.remove(j - i);
        }*/

    }
    public void playGame() {
        numberOfPlayers();
        boolean flag = false;
        while (!flag) {
            for (int i = 0; i < Game.player.size(); i++) {
                System.out.println("\nPlayer " + (player.get(i).getPlayerNumber()) + "'s turn");
                getPlayer(i).checkHandForValidPlays();
                boolean flags = false;
                while (!flags) {
                    switch (getPlayer(i).makeChoice()) {
                        case ("q") -> {
                            System.out.println("Turn Skipped");
                            flags = true;
                        }
                        case ("s") -> {
                            getPlayer(i).showHand();
                            System.out.println(DiscardPile.showTopCard());
                        }
                        case ("p") -> {
                            try {
                                System.out.println(DiscardPile.showTopCard());
                                getPlayer(i).playCard();
                                flags = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Numbers only as the allowed input");
                            }
                        }
                        default -> flags = true;
                    }
                }
                if (getPlayer(i).getHandSize() == 0) {
                    System.out.println("Player " + (player.get(i).getPlayerNumber()) + " wins!");
                    flag = true;
                }
            }
        }
    }
}
