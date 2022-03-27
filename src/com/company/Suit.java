package com.company;

public enum Suit {
    CLUBS(1), DIAMONDS(2), SPADES(3), HEARTS(4);

    private final int suitValue;

    Suit(int sv) {
        suitValue = sv;
    }

    public int getSuitValue() {
        return suitValue;
    }
}