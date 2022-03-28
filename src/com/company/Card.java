package com.company;

public class Card implements Comparable<Card> {
    private Rank rank;
    private Suit suit;
    private static int maxRank = 2;

    Card(int rank, String suit) {
        setRank(rank);
        setSuit(suit);
    }

    Card(String suit) {
        setSuit(suit);
        setRank(maxRank);
        if (maxRank < 14) {
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

    // Проверяющий, является ли текущая карта сильнее другой (масть одинакова,
    // значение больше).
    public int whoIsStronger(Card card) {
        if (this.getSuit().equals(card.getSuit())) {
            return Integer.compare(this.rank.getRankValue(), card.rank.getRankValue());
        } else if ((this.getRank() == Rank.JOKER) || (card.getRank() == Rank.JOKER)) {
            return 1;
        } else {
            return -2; // если масть разная
        }
    }

    //Проверяющий, что карта принадлежит к стандартной колоде (54 карты). В
    //качестве джокеров можно принять карты любых двух мастей со значением
    //большим, чем у туза.
    public boolean belongs52() {
        return this.getRank() != Rank.JOKER;
    }

    //Сравнивающий текущую карту с другой. Предполагается, что для мастей clubs <
    //diamonds < spades < hearts. Нужно вернуть значение меньше нуля если текущая
    //меньше, 0 если они равны, и значение больше нуля, если текущая больше.
    //Добавьте аналогичный статический метод, сравнивающий две карты.
    public int compareCard(Card card) {
        return Integer.compare(this.suit.getSuitValue(), card.getSuit().getSuitValue());
    }

    @Override
    public String toString(){
        return rank + " " + suit;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Card card = (Card) obj;
        return rank == card.rank &&
               suit == card.suit;
    }

    @Override
    public int compareTo(Card card) {
        if (this.getSuit().equals(card.getSuit())) {
            return whoIsStronger(card);
        } return compareCard(card);
    }
}
