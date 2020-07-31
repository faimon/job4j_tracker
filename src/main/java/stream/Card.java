package stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .map(suit -> Stream.of(Value.values())
                        .map(value -> new Card(suit, value))
                        .collect(Collectors.toList()))
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Card{" + "suit="
                + suit
                + ", value="
                + value + '}';
    }
}