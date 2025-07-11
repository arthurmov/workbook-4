package com.pluralsight;

import java.util.ArrayList;

public class Hand {

    private final ArrayList<Card> cards;

    public Hand(){
        cards = new ArrayList<Card>();
    }

    public ArrayList<Card> getCards(){
        return this.cards;
    }

    public void deal(Card card){
        this.cards.add(card);
    }

    public int getSize(){
        return this.cards.size();
    }

    public int getValue(){
        int total = 0;
        for(Card c:this.cards){
            total += c.getPointValue();
        }
        return total;
    }

}