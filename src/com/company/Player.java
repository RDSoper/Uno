package com.company;

import java.util.*;

import static com.company.Deck.drawCard;
import static com.company.DiscardPile.*;


public class Player {
    /**
     * Fields for Player class.
     */
    ArrayList<Card> hand;
    Scanner sc;
    ArrayList<String> controls;
    int number;

    /**
     * Constructor for Player class.
     * Creates empty ArrayList of type Card and then draws 7 cards from the Deck class.
     */
    public Player(int playerNumber) {
        this.number = playerNumber+1;
        this.sc = new Scanner(System.in);
        this.hand = new ArrayList<>();
        this.controls = new ArrayList<>();
        while (hand.size() != 7) {
            draw();
        }
        controls.add("s");
        controls.add("p");
        controls.add("q");
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
            if(card.getSpecial()==null) {
                System.out.print(i + 1 + ": " + card.getColor() + " " + card.getValue() + "\n");
                i++;
            }else{
                System.out.print(i + 1 + ": " + card.getColor() + " " + card.getSpecial() +"\n");
                i++;
            }
        }
    }

    public int getPlayerNumber(){
        return number;
    }

    /**
     * Shows the player their hand and asks them which card they want to play. If that cards colour or value matches
     * the top card of the discard pile, it adds it to the top. If not, it prompts the player for another card.
     */
    public void playCard() {
        showHand();
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the number corresponding to the card you want to play.");
        int i = sc.nextInt();
        Card temp = hand.get(i-1);
        if (DiscardPile.getValue() == temp.getValue() || DiscardPile.getColor().equals(temp.getColor())) {
            play.add(temp);
            hand.remove(i-1);
        } else {
            System.out.println("That card doesn't match the card in the play area, please choose again.");
        }
    }

    /**
     * Checks the cards in the players hand against the top card of the discard pile. If there are no matches amongst
     * the value or color fields and the card isn't a special type, will force the player to draw a card. Otherwise,
     * does nothing as the player has at least one card they can play.
     */
    public void checkHandForValidPlays() {
        //Checks the hand for matches amongst the color or value fields.
        boolean validPlay = false;
        for (Card card : hand) {
            if (card.getValue() == play.get(play.size()-1).getValue()||
                card.getColor().equals(play.get(play.size()-1).getColor())||
                !(card.getSpecial()==null)){
                validPlay = true;
                break;
            }
        }
        //If there are no matches, the player has no cards they can play. Player draws a card and then begins game
        // resumes.
        if (!validPlay) {
            System.out.println("\nYou are out of valid plays. Draw a card!");
            hand.add(drawCard());
        }
    }

    /**
     * Controls game flow, gives player a choice and acts according to that choice.
     */
    public String makeChoice() {

        String decision = "";
        while (!controls.contains(decision)) {
            System.out.println("""
                Controls:
                s: see your hand.
                p: play a card.
                q: skip turn.
                """);

            decision = sc.nextLine();
            if(!controls.contains(decision)){
                System.out.println("Please enter a valid choice.");
            }
        }
        return decision;
    }
}



