package poker.hands.ranks;

import poker.hands.Card;
import poker.hands.Hand;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class OnePair extends Hand {
    public OnePair(List<Card> cards) {
        super(cards);
        Map<Integer, Integer> valueOccurrences = valueOccurrences();
        rankedValues = List.of(valueOccurrences.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 2)
                .findFirst()
                .orElseThrow()
                .getKey());

        unrankedValues = valueOccurrences.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(toList());
    }

    @Override
    protected int rank() {
        return 1;
    }
}
