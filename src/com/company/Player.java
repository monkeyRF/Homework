package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    public String name;
    public ArrayList<Card> cards = new ArrayList<>();

    Player(String name) {
        this.name = name;
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public Card getCard(){
        Random random = new Random();
        Card card = cards.get(random.nextInt(cards.size()));
        cards.remove(card);
        return card;
    }

    public void remove(Card card){
        cards.remove(card);
    }

    @Override
    public String toString(){
        return name + ", " + "в руке " + cards.size() + " карты \n" + cards;
    }
}
