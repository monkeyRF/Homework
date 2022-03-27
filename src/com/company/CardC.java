package com.company;

public class CardC {
    private Rank rank;
    private Suit suit;
    private static int maxRank = 2;

    CardC(int rank, String suit) {
        setRank(rank);
        setSuit(suit);
    }

    CardC(String suit) {
        setSuit(suit);
        setRank(maxRank);
        if (maxRank < 15) {
            maxRank++;
        } else {
            maxRank = 2;
        }
    }

    public void setRank(int rank) {
        if ((rank-2 < Rank.values().length) || (rank-2 > Rank.values().length)) {
            Rank[] ranks = Rank.values();
            this.rank = ranks[rank-2];
        } else {
            System.out.println("Ранг " + rank + " отсутствует в стандартной колоде");
        }
    }

    public void setSuit(String suit){
        try {
            this.suit = Suit.valueOf(suit);
        } catch (IllegalArgumentException e) {
            System.out.println(suit + " отсутствует в списке мастей");
        }
    }

    public Rank getRank(){
        return this.rank;
    }

    public Suit getSuit(){
        return  this.suit;
    }

    @Override
    public String toString(){
        return rank + " " + suit;
    }
}