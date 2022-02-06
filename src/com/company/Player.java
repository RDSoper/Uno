package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.company.Deck.drawCard;
import static com.company.DiscardPile.*;


public class Player {
    /**
     * Fields for Player class.
     */
    ArrayList<Card> hand;
    Scanner sc;

    /**
     * Constructor for Player class.
     * Creates empty ArrayList of type Card and then draws 7 cards from the Deck class.
     */
    public Player() {
        this.sc = new Scanner(System.in);
        this.hand = new ArrayList<>();
        while (hand.size() != 7) {
            draw();
        }
    }

    /**
     * Getter for number of cards in hand.
     */
    public int getHandSize() {
        return hand.size();
    }

    public void draw() {
        hand.add(drawCard());
    }

    public void showHand() {
        int i = 0;
        for (Card card : hand) {
            System.out.print(i + 1 + ": " + card.getColor() + " " + card.getValue() + "\n");
            i++;
        }
    }


    public void playCard() {
        showHand();
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the number corresponding to the card you want to play.");
        int i = sc.nextInt();
        Card temp = hand.get(i - 1);
        if (DiscardPile.getValue() == temp.getValue() || DiscardPile.getColor().equals(temp.getColor())) {
            play.add(temp);
            hand.remove(i - 1);
            System.out.println("The top card is now " + DiscardPile.showTopCard());
        } else {
            System.out.println("That card doesn't match the card in the play area, please choose again.");
        }
    }

    /**
     * Checks the cards in the players hand against the top card of the discard pile. If there are no matches amongst
     * the value or color fields will force the player to draw a card, and play it if they can. Otherwise, does nothing
     * as the player has at least one card they can play.
     */
    public void checkHandForValidPlays() {
        //Checks the hand for matches amongst the color or value fields.
        boolean validPlay = false;
        for (Card card : hand) {
            if (card.getValue() == play.get(play.size() - 1).getValue() ||
                    card.getColor().equals(play.get(play.size() - 1).getColor())) {
                validPlay = true;
                break;
            }
        }
        //If there are no matches, the player has no cards they can play. PLayer draws a card, then if it matches the
        //top of the discard pile asked to play it.
        if (!validPlay) {
            System.out.println("\nYou are out of valid plays. Draw a card!");
            hand.add(drawCard());
        }
    }


    /**
     * Checks if the players hand size is 0, if it is, it means they have no cards and have won.
     */
    public void beginGame() {

        boolean flag = false;
        while (!flag) {
            System.out.println("""
                Controls:
                s: see your hand.
                p: play a card.
                q: skip turn.
                """);
            String decision = sc.nextLine();
            switch (decision) {
                case ("q"): {
                    flag = true;
                    break;
                }
                case ("s"):
                    System.out.println("Your hand is currently ");
                    showHand();
                    System.out.print("\nThe top card is " + DiscardPile.showTopCard() + "\n");
                    break;
                case ("p"):
                    try {
                        System.out.print("\nThe top card is " + DiscardPile.showTopCard() + "\n");
                        playCard();
                        flag = true;
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Numbers only as the allowed input");
                        break;
                    }
                default:
                    System.out.println("Command not recognised.");
            }
        }
    }
}



