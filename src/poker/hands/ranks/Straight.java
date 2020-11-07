package poker.hands.ranks;

import poker.hands.Card;
import poker.hands.Hand;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Straight extends Hand {
    public Straight(List<Card> cards) {
        super(cards);
        Map<Integer, Integer> valueOccurrences = valueOccurrences();
        rankedValues = valueOccurrences.keySet().stream().sorted().collect(Collectors.toList());
    }

    @Override
    protected int rank() {
        return 4;
    }
}
