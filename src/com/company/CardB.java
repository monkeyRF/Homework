package com.company;

public class CardB {
    private Rank rank;
    private Suit suit;

    CardB(int rank, String suit) {
        setRank(rank);
        setSuit(suit);
    }

    public void setRank(int rank) {
        if ((rank-2 < Rank.values().length) || (rank-2 > Rank.values().length)) {
            Rank[] ranks = Rank.values();
            Rank r = ranks[rank-2];
            this.rank = r;
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