package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
            for (int j=0; j<= rk.length-2; j++) {
                cards.add(new Card(st[i].toString()));
            }
        }
        return deck;
    }

    static Deck create54(){
        name = "Колода с джокерами (54 карты)";
        Suit[] st = Suit.values();
        Rank[] rk = Rank.values();
        for (int i=0; i<= st.length-1; i++) {
            for (int j=0; j<= rk.length-2; j++) {
                cards.add(new Card(st[i].toString()));
            }
        }
        cards.add(new Card(14, "HEARTS"));
        cards.add(new Card(14, "DIAMONDS"));
        return deck;
    }

    public static Card getRandomCard() {
        Random random = new Random();
        return cards.get(random.nextInt(cards.size()));
    }

    public static Card getRandomCardRemove() {
        Random random = new Random();
        Card card = cards.get(random.nextInt(cards.size()));
        cards.remove(card);
        return card;
    }

    public static void mixing() {
        Collections.shuffle(cards);
    }

    public static void sort() {
        Collections.sort(cards);
    }

    public static void returnCard(Card card){
        if (cards.contains(card))
            System.out.println("Карта уже есть в колоде, пропустим: " + card.toString());
        else {
            cards.add(card);
        }
    }

    public static Boolean isEmpty() {
        return cards.isEmpty();
    }

    @Override
    public String toString() {
        return name + "\n" + "В колоде сейчас " + cards.size() + " карты: \n" + cards;
    }
}
