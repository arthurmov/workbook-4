package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Console console = new Console();

    public static void main(String[] args) {

        //welcome message
        System.out.println(ColorCodes.RED + "Welco"  + ColorCodes.RESET +  "me to B" + ColorCodes.RED + "lackj" + ColorCodes.RESET
                + "ack at" + ColorCodes.RED + " the Ha" + ColorCodes.RESET + "rdRo" + ColorCodes.RED + "ck Cas" + ColorCodes.RESET + "ino!");

        Deck d = new Deck();
        d.shuffle();

        List<Player> players = new ArrayList<>();
        
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
            display(player);
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
        System.out.println("Together they have the value of " + player.getHand().getValue());
    }
}