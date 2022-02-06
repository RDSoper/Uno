package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Scanner sc;

    public Game() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Begins a two player game of uno.
     */
    public void beginTwoPlayerGame() {
        Player one = new Player();
        Player two = new Player();
        System.out.println("Sup, welcome to Uno, the game ends when someone has no cards left.");
        boolean flag = false;
        while (!flag) {
            System.out.println("It's player 1's turn");
            one.checkHandForValidPlays();
            one.beginGame();
            System.out.println("It's player 2's turn");
            two.checkHandForValidPlays();
            two.beginGame();
            if(one.getHandSize()==0){
                System.out.println("Player one has no cards in hand, player one wins!");
                flag = true;
            }
            if(two.getHandSize()==0){
                System.out.println("Player two has no cards in hand, player two wins!");
                flag = true;
            }
        }
    }

    /**
     * Begins a three player game of uno.
     */
    public void beginThreePlayerGame() {
        Player one = new Player();
        Player two = new Player();
        Player three = new Player();
        System.out.println("Sup, welcome to Uno, the game ends when someone has no cards left.");
        boolean flag = false;
        while (!flag) {
            System.out.println("It's player 1's turn");
            one.checkHandForValidPlays();
            one.beginGame();
            System.out.println("It's player 2's turn");
            two.checkHandForValidPlays();
            two.beginGame();
            System.out.println("It's player 3's turn");
            three.checkHandForValidPlays();
            three.beginGame();
            if(one.getHandSize()==0){
                System.out.println("Player one has no cards in hand, player one wins!");
                flag = true;
            }
            if(two.getHandSize()==0){
                System.out.println("Player two has no cards in hand, player two wins!");
                flag = true;
            }
            if(three.getHandSize()==0){
                System.out.println("Player three has no cards in hand, player three wins!");
                flag = true;
            }
        }
    }

    /**
     * Begins a three player game of uno.
     */
    public void beginFourPlayerGame() {
        Player one = new Player();
        Player two = new Player();
        Player three = new Player();
        Player four = new Player();
        System.out.println("Sup, welcome to Uno, the game ends when someone has no cards left.");
        boolean flag = false;
        while (!flag) {
            System.out.println("It's player 1's turn");
            one.checkHandForValidPlays();
            one.beginGame();
            System.out.println("It's player 2's turn");
            two.checkHandForValidPlays();
            two.beginGame();
            System.out.println("It's player 3's turn");
            three.checkHandForValidPlays();
            three.beginGame();
            System.out.println("It's player 4's turn");
            four.checkHandForValidPlays();
            four.beginGame();
            if(one.getHandSize()==0){
                System.out.println("Player 1 has no cards in hand, player 1 wins!");
                flag = true;
            }
            if(two.getHandSize()==0){
                System.out.println("Player 2 has no cards in hand, player 2 wins!");
                flag = true;
            }
            if(three.getHandSize()==0){
                System.out.println("Player 3 has no cards in hand, player 3 wins!");
                flag = true;
            }
            if(four.getHandSize()==0){
                System.out.println("Player 4 has no cards in hand, player 4 wins!");
                flag = true;
            }
        }
    }

    /**
     * Begins the right game according to the number of players.
     */
    public void numberOfPlayers(){
        System.out.println("How many players are playing uno? Minimum of two, maximum of four.");
        int choice = 0;
        try{
            choice = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Please type a number between 2 and 4.");
        }
        switch (choice) {
            case (2) -> beginTwoPlayerGame();
            case (3) -> beginThreePlayerGame();
            case (4) -> beginFourPlayerGame();
        }
    }
}

