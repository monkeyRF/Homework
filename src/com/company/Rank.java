package com.company;

public enum Rank {
    TWO(2), THREE(3), FOUR(4), FIVE(5),
    SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(11), QUEEN(12), KING(13), AS(14), JOKER(15);

    private final int rankValue;

    Rank(int sv) {
        rankValue = sv;
    }

    public int getRankValue() {
        return rankValue;
    }
}