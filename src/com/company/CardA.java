package com.company;

public class CardA {
    public Rank rank;
    public Suit suit;

    CardA() {
    }

    @Override
    public String toString(){
        return rank + " " + suit;
    }
}
