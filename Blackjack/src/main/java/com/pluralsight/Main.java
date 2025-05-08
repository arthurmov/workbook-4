package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Console console = new Console();

    public static void main(String[] args) {

        //welcome message
        System.out.println(ColorCodes.RED + "Welco"  + ColorCodes.RESET +  "me to B" + ColorCodes.RED + "lackj" + ColorCodes.RESET
                + "ack at" + ColorCodes.RED + " the Ha" + ColorCodes.RESET + "rdRo" + ColorCodes.RED + "ck Cas" + ColorCodes.RESET + "ino!");

        Deck d = new Deck();
        d.shuffle();

        List<Player> players = new ArrayList<>();

        Player dealer = new Player("Dealer");
        dealer.setHand((new Hand()));

        //deals cards to the dealer
        for (int i = 0; i < 2; i++) {
            Card c = d.deal();
            if (c != null) {
                c.flip();
                dealer.getHand().deal(c);
            }
        }

        int numOfPlayers = console.promptForInt("Enter the number of players: ");

        //gets name for each player
        for(int i = 0 ; i < numOfPlayers ; i++) {
            String name = console.promptForString("Enter the name of player " + (i+1) + ": ");
            Player player = new Player(name);
            player.setHand(new Hand());
            players.add(player);
        }

        //deals two cards to each player
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                Card c = d.deal();
                if (c != null) {
                    c.flip();
                    player.getHand().deal(c);
                }
            }
        }

        //displays each players hand
        for (Player player : players) {
            hitOrStand(player, d);
        }


        System.out.println("\nDealer's turn:");
        while (dealer.getHand().getValue() < 17) {
            Card c = d.deal();
            if (c != null) {
                c.flip();
                dealer.getHand().deal(c);
                System.out.println("Dealer hits:");
                display(c);
            }
        }
        display(dealer);

        for (Player player : players) {
            winner(player, dealer);
        }
    }

    public static void display(Card c){
        if(c.getSuit().equalsIgnoreCase("Hearts") || c.getSuit().equalsIgnoreCase("Diamonds") ){
            System.out.println(ColorCodes.RED + c.getValue() + " " + c.getSuit() + ColorCodes.RESET );
        }
        else if
             (c.getSuit().equalsIgnoreCase("Spades") || c.getSuit().equalsIgnoreCase("Clubs") ){
                System.out.println(ColorCodes.BLACK + c.getValue() + " " + c.getSuit() + ColorCodes.RESET );
        }
        else{
            System.out.println(c.getValue() + " " + c.getSuit());
        }
    }

    public static void display(Player player){
        System.out.println("\n" + player.getPlayerName() +" has the follow cards:");
        for(Card card: player.getHand().getCards()){
            display(card);
        }
        System.out.println("Together they have the value of " + player.getHand().getValue() + "\n");
    }

    public static void winner(Player player, Player dealer) {
        int playerVal = player.getHand().getValue();
        int dealerVal = dealer.getHand().getValue();

        if (playerVal > 21) {
            System.out.println(player.getPlayerName() + " busted! Dealer wins.");
        } else if (dealerVal > 21) {
            System.out.println("Dealer busted! " + player.getPlayerName() + " wins.");
        } else if (playerVal == 21 && !(dealerVal == 21)) {
            System.out.println(player.getPlayerName() + " got a BLACKJACK!");
        } else if (playerVal > dealerVal) {
            System.out.println(player.getPlayerName() + " wins with " + playerVal + " against dealer's " + dealerVal);
        } else if (playerVal < dealerVal) {
            System.out.println("Dealer wins against " + player.getPlayerName());
        } else {
            System.out.println(player.getPlayerName() + " and Dealer tied!");
        }
    }

    public static void hitOrStand(Player player, Deck d) {
        boolean turnOver = false;

        while (!turnOver) {
            display(player);

            int handValue = player.getHand().getValue();
            if (handValue >= 21) {
                if (handValue > 21) {
                    System.out.println(player.getPlayerName() + " busted!");
                }
                break;
            }

            String action = console.promptForString("Would " + player.getPlayerName() + " like to Hit or Stand? ").toLowerCase();

            switch (action) {
                case "hit":
                    Card c = d.deal();
                    if (c != null) {
                        c.flip();
                        player.getHand().deal(c);
                        System.out.println(player.getPlayerName() + " hits and receives:");
                        display(c);
                    }
                    break;
                case "stand":
                    System.out.println(player.getPlayerName() + " stands with " + player.getHand().getValue());
                    turnOver = true;
                    break;
                default:
                    System.out.println("Invalid input. Please enter H or S.");
            }
        }
    }
}