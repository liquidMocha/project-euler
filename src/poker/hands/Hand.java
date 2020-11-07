package poker.hands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static poker.hands.HandFactory.allValues;

public abstract class Hand {
    private final List<Card> cards;
    public List<Integer> rankedValues = new ArrayList<>();
    public List<Integer> unrankedValues = new ArrayList<>();

    protected Hand(List<Card> cards) {
        this.cards = cards;
    }

    abstract protected int rank();

    public boolean higherThan(Hand otherHand) {
        if (rank() > otherHand.rank()) {
            return true;
        } else if (rank() < otherHand.rank()) {
            return false;
        } else {
            for (int i = rankedValues.size() - 1; i >= 0; i--) {
                if (this.rankedValues.get(i) > otherHand.rankedValues.get(i)) {
                    return true;
                } else if (this.rankedValues.get(i) < otherHand.rankedValues.get(i)) {
                    return false;
                }
            }

            for (int i = unrankedValues.size() - 1; i >= 0; i--) {
                if (this.unrankedValues.get(i) > otherHand.unrankedValues.get(i)) {
                    return true;
                } else if (this.unrankedValues.get(i) < otherHand.unrankedValues.get(i)) {
                    return false;
                }
            }
            return false;
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public Map<Integer, Integer> valueOccurrences() {
        Map<Character, Integer> numberOfOccurrences = HandFactory.valueOccurrences(cards);

        return numberOfOccurrences.entrySet().stream()
                .map(entry -> Map.entry(allValues.indexOf(entry.getKey()), entry.getValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
