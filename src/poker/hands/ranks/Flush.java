package poker.hands.ranks;

import poker.hands.Card;
import poker.hands.Hand;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Flush extends Hand {
    public Flush(List<Card> cards) {
        super(cards);
        Map<Integer, Integer> valueOccurrences = valueOccurrences();
        rankedValues = valueOccurrences
                .keySet()
                .stream()
                .sorted()
                .collect(toList());
    }

    @Override
    protected int rank() {
        return 5;
    }
}
