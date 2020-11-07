package poker.hands.ranks;

import poker.hands.Card;
import poker.hands.Hand;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class TwoPairs extends Hand {
    public TwoPairs(List<Card> cards) {
        super(cards);
        Map<Integer, Integer> valueOccurrences = valueOccurrences();
        unrankedValues = List.of(valueOccurrences.entrySet()
                .stream().filter(entry -> entry.getValue() == 1)
                .findFirst().orElseThrow().getKey());
        rankedValues = valueOccurrences.entrySet()
                .stream().filter(entry -> entry.getValue() == 2)
                .map(Map.Entry::getKey).collect(toList());
    }

    @Override
    protected int rank() {
        return 2;
    }
}
