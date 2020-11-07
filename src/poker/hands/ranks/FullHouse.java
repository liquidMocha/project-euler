package poker.hands.ranks;

import poker.hands.Card;
import poker.hands.Hand;

import java.util.List;
import java.util.Map;

public class FullHouse extends Hand {
    public FullHouse(List<Card> cards) {
        super(cards);
        Map<Integer, Integer> valueOccurrences = valueOccurrences();
        rankedValues.add(
                valueOccurrences.entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() == 2)
                        .findFirst().orElseThrow().getKey()
        );
        rankedValues.add(
                valueOccurrences.entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() == 3)
                        .findFirst().orElseThrow().getKey()
        );
    }

    @Override
    protected int rank() {
        return 6;
    }

}
