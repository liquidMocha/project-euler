package poker.hands.ranks;

import poker.hands.Card;
import poker.hands.Hand;

import java.util.List;
import java.util.Map;

public class FourOfAKind extends Hand {
    public FourOfAKind(List<Card> cards) {
        super(cards);
        Map<Integer, Integer> valueOccurrences = valueOccurrences();
        rankedValues = List.of(valueOccurrences.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 4)
                .findFirst()
                .orElseThrow().getKey());
        unrankedValues = List.of(valueOccurrences.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst().orElseThrow().getKey());
    }

    @Override
    protected int rank() {
        return 7;
    }

}
