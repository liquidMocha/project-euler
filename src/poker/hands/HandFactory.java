package poker.hands;

import poker.hands.ranks.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class HandFactory {
    static List<Character> allValues = List.of('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A');

    public static Hand createHand(List<Card> cards) {
        if (isRoyalFlush(cards)) {
            return new RoyalFlush(cards);
        } else if (isStraightFlush(cards)) {
            return new StraightFlush(cards);
        } else if (isFourOfAKind(cards)) {
            return new FourOfAKind(cards);
        } else if (isFullHouse(cards)) {
            return new FullHouse(cards);
        } else if (isFlush(cards)) {
            return new Flush(cards);
        } else if (isStraight(cards)) {
            return new Straight(cards);
        } else if (isThreeOfAKind(cards)) {
            return new ThreeOfAKind(cards);
        } else if (isTwoPairs(cards)) {
            return new TwoPairs(cards);
        } else if (isOnePair(cards)) {
            return new OnePair(cards);
        } else {
            return new HighCard(cards);
        }
    }

    static boolean isStraight(List<Card> cards) {
        List<Character> cardValues = getCardValues(cards);
        List<Integer> positions = cardValues.stream().map(cardValue -> allValues.indexOf(cardValue)).sorted().collect(toList());
        for (int i = 0; i < positions.size() - 1; i++) {
            if (positions.get(i) + 1 != positions.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    static boolean isRoyalFlush(List<Card> cards) {
        List<Character> values = getCardValues(cards);
        return values.containsAll(List.of('T', 'J', 'Q', 'K', 'A')) && sameSuit(cards);
    }

    static boolean isStraightFlush(List<Card> cards) {
        return isStraight(cards) && sameSuit(cards);
    }

    static boolean hasXOfAKind(List<Card> cards, int numberOfOccurrences) {
        return getCardValues(cards)
                .stream()
                .anyMatch(value -> getCardValues(cards).stream().filter(v -> v == value).count() == numberOfOccurrences);
    }

    static boolean isFourOfAKind(List<Card> cards) {
        return hasXOfAKind(cards, 4);
    }

    static boolean isFullHouse(List<Card> cards) {
        return hasXOfAKind(cards, 2) && hasXOfAKind(cards, 3);
    }

    static boolean isFlush(List<Card> cards) {
        return sameSuit(cards);
    }

    static boolean isThreeOfAKind(List<Card> cards) {
        return hasXOfAKind(cards, 3);
    }

    static boolean isTwoPairs(List<Card> cards) {
        Map<Character, Integer> numberOfOccurrences = valueOccurrences(cards);

        return 2 == numberOfOccurrences.values()
                .stream()
                .filter(occurrences -> occurrences == 2)
                .count();
    }

    static boolean isOnePair(List<Card> cards) {
        return hasXOfAKind(cards, 2);
    }

    private static boolean sameSuit(List<Card> cards) {
        return cards.stream().map(Card::getSuit).collect(toSet()).size() == 1;
    }

    static public List<Character> getCardValues(List<Card> cards) {
        return cards.stream().map(Card::getValue).collect(toList());
    }

    static public Map<Character, Integer> valueOccurrences(List<Card> cards) {
        Map<Character, Integer> numberOfOccurrences = new HashMap<>();
        cards.stream().map(Card::getValue).forEach(value -> {
            if (numberOfOccurrences.containsKey(value)) {
                numberOfOccurrences.put(value, numberOfOccurrences.get(value) + 1);
            } else {
                numberOfOccurrences.put(value, 1);
            }
        });
        return numberOfOccurrences;
    }
}
