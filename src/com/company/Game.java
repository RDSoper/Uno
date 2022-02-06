package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Scanner sc;
    static ArrayList<Player> player;

    public Game() {
        this.sc = new Scanner(System.in);
        player = new ArrayList<>();
    }

    public Player getPlayer(int i){
        return player.get(i);
    }

    public void numberOfPlayers(){
        System.out.println("How many players are playing uno? Number between 2 and 10");
        int players;
        players = sc.nextInt();
        for(int i =0; i<players;i++ ){
            player.add(new Player());
            System.out.println("Player "+(i+1)+" added.");
        }
    }

    public void playGame() {
        numberOfPlayers();
        boolean flag = false;
        while (!flag) {
            for (int i = 0; i < Game.player.size(); i++) {
                System.out.println("\nPlayer "+(i+1)+"'s turn");
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
                    System.out.println("Player " + (i + 1) + " wins!");
                    flag = true;
                }
            }
        }
    }
}
