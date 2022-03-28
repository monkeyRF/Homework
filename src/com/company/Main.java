package com.company;

public class Main {
    public static void main(String[] args) {

        System.out.println("2.а С конструктором по умолчанию и двумя изменяемыми полями");
        CardA cardA = new CardA();
        cardA.rank = Rank.TEN;
        cardA.suit = Suit.DIAMONDS;
        System.out.println(cardA);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("2.b С установкой начальных значений в конструкторе, закрытыми полями и методами чтения значений.\n" +
                "Проверяйте значение suit – в случае ошибки выводите на экран соответствующее сообщение.");
        CardB cardB = new CardB(9, "SPADES1");
        System.out.println(cardB.getRank() + " " + cardB.getSuit());

        // 2.c Модификацию варианта b, с дополнительным конструктором, принимающим
        //только suit. В качестве rank нужно устанавливать maxRank + 1, где maxRank –
        //максимальное известное значение rank для заданного suit (может
        //потребоваться одно или более статических полей)
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("""
                2.c Модификацию варианта b, с дополнительным конструктором, принимающим
                только suit. В качестве rank нужно устанавливать maxRank + 1, где maxRank –
                максимальное известное значение rank для заданного suit (может
                потребоваться одно или более статических полей)""");
        CardC cardC = new CardC("HEARTS");
        System.out.println(cardC);
        CardC card1 = new CardC("HEARTS");
        System.out.println(card1);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("""
                3 Модифицируйте класс версии b из предыдущего задания. \s
                Реализуйте методы toString (с именами мастей и названиями достоинств – Jack, Queen,\s
                и т.д.), equals и hashCode.""");
        Card card = new Card("HEARTS");
        Card card2 = new Card("SPADES");

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("3.1 Реализуйте методы toString");
        System.out.println(card);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("3.2 Реализуйте методы equals");
        System.out.println("Сравним " + card + " c " + card2 + " = " + card.equals(card2));
        System.out.println("Сравним " + card + " c " + card + " = " + card.equals(card));

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("3.2 Реализуйте методы equals");
        System.out.println("Сравним " + card + " c " + card2 + " = " + card.equals(card2));
        System.out.println("Сравним " + card + " c " + card + " = " + card.equals(card));

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("3.3 Реализуйте методы hashCode");
        System.out.println("hashCode " + card + " " + card.hashCode());
        System.out.println("hashCode " + card2 + " " + card2.hashCode());
        System.out.println("Сравним "+ card + " c " + card2 + " = " + (card.hashCode() == card2.hashCode()));
        System.out.println("Сравним "+ card + " c " + card + " = " + (card.hashCode() == card.hashCode()));

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("""
                3.a Проверяющий, что карта принадлежит к стандартной колоде (52 карты). В\s
                качестве джокеров можно принять карты любых двух мастей со значением\s
                большим, чем у туза.""");
        System.out.println("Проверим "+ card + " = " + card.belongs52());
        Card cardJoker = new Card(14,"HEARTS");
        System.out.println("Проверим "+ cardJoker + " = " + cardJoker.belongs52());

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("3.b Проверяющий, является ли текущая карта сильнее другой (масть одинакова, \n" +
                "значение больше).");
        Card card2Hearts = new Card(2,"HEARTS");
        System.out.println("Сравним "+ card + " c " + card2Hearts + " = " + card.whoIsStronger(card2Hearts));
        Card card3Hearts = new Card(3,"HEARTS");
        System.out.println("Сравним "+ card + " c " + card3Hearts + " = " + card.whoIsStronger(card3Hearts));
        Card card4Spades = new Card(4,"SPADES");
        if (card3Hearts.whoIsStronger(card4Spades) != -2) {
            System.out.println("Сравним "+ card3Hearts + " c " + card4Spades + " = " + card3Hearts.whoIsStronger(card4Spades));
        } else {
            System.out.println("Сравним "+ card3Hearts + " c " + card4Spades + " = разные масти!");
        }

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("""
                3.c Сравнивающий текущую карту с другой. Предполагается, что для мастей clubs <\s
                diamonds < spades < hearts. Нужно вернуть значение меньше нуля если текущая\s
                меньше, 0 если они равны, и значение больше нуля, если текущая больше.\s
                Добавьте аналогичный статический метод, сравнивающий две карты.""");
        System.out.println("Сравним "+ card + " c " + card4Spades + " = " + card.compareCard(card4Spades));
        Card card7Diamonds = new Card(7,"DIAMONDS");
        System.out.println("Сравним "+ card7Diamonds + " c " + card4Spades + " = " + card7Diamonds.compareCard(card4Spades));
        System.out.println("Сравним "+ card + " c " + card3Hearts + " = " + card.compareCard(card3Hearts));

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("""
                4. Реализуйте класс Deck, представляющий стандартную колоду карт. Для хранения карт\s
                (из предыдущего задания) используйте ArrayList. Сделайте конструктор закрытым, а\s
                для создания экземпляров оформите статические методы для создания колоды с\s
                джокерами, либо без них.""");
        Deck deck = Deck.create52();
        System.out.println(deck);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("4.1 Статический метод, возвращающий случайную карту из стандартной колоды.");
        System.out.println(Deck.getRandomCard());

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("4.2 Для перемешивания карт.");
        Deck.mixing();
        System.out.println(deck);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("4.3 Для сортировки карт (реализуйте интерфейс Comparable<Card> в Card, \n" +
                "используя добавленный ранее метод сравнения).");
        Deck.sort();
        System.out.println(deck);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("4.4 Для раздачи карты (извлечения из колоды).");
        Player player = new Player("Иван");
        Card cardPlay = Deck.getRandomCardRemove();
        player.addCard(cardPlay);
        System.out.println("Игроку " + player.name + " раздаем карту из колоды: " + cardPlay);
        cardPlay = Deck.getRandomCardRemove();
        player.addCard(cardPlay);
        System.out.println("Игроку " + player.name + " раздаем карту из колоды: " + cardPlay);
        System.out.println(deck);
        System.out.println(player);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("4.5 Для возврата карты в колоду (убедитесь, что карта отсутствует в колоде)");
        cardPlay = player.getCard();
        System.out.println("Игрок " + player.name + " возвращает карту в колоду: " + cardPlay);
        Deck.returnCard(cardPlay);
        player.remove(cardPlay);
        System.out.println(deck);
        System.out.println(player);
        System.out.println("Игрок " + player.name + " возвращает копию карты: " + cardPlay);
        Deck.returnCard(cardPlay);
        System.out.println(deck);
        System.out.println(player);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("4.6 Для проверки на пустоту.");
        System.out.println("Игрок " + player.name + " получает в руку всю колоду");
        while (!Deck.isEmpty()) {
            cardPlay = Deck.getRandomCardRemove();
            player.addCard(cardPlay);
        }
        System.out.println(deck);
        System.out.println(player);


        System.out.println("Игрок " + player.name + " вернул все карты в колоду");
        while (!player.cards.isEmpty()) {
            cardPlay = player.getCard();
            //System.out.println("Игрок " + player.name + " возвращает копию карты: " + cardPlay);
            Deck.returnCard(cardPlay);
            player.remove(cardPlay);
        }
        System.out.println(deck);
        System.out.println(player);

        Deck.sort();

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("4.7 Реализацию toString");
        System.out.println(deck);

    }
}
