package com.company;

import java.util.ArrayList;

public class Deck {
    private static String name;
    private static final Deck deck = new Deck();
    private static final ArrayList<Card> cards = new ArrayList<>();

    private Deck() {}

    static Deck create52(){
        name = "Стандартная колода (52 карты)";
        Suit[] st = Suit.values();
        Rank[] rk = Rank.values();
        for (int i=0; i<= st.length-1; i++) {
            for (int j=0; j<= rk.length-4; j++) {
                cards.add(new Card(st[i].toString()));
            }
        }
        return deck;
    }

    public static ArrayList<Card> getCards() {
        return cards;
    }

        /*else if (count == 54) {
            Suit[] st = Suit.values();
            Rank[] rk = Rank.values();
            for (int i=0; i<= st.length-1; i++) {
                for (int j=0; j<= rk.length-2; j++) {
                    cards.add(new Card(st[i].toString()));
                }
            }
        } else {

            }
        }
    }*/
    @Override
    public String toString() {
        return name + "\n" +cards;
    }
}
