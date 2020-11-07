package poker.hands.ranks;

import poker.hands.Card;
import poker.hands.Hand;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StraightFlush extends Hand {
    public StraightFlush(List<Card> cards) {
        super(cards);
        rankedValues = valueOccurrences()
                .keySet()
                .stream()
                .sorted()
                .collect(toList());
    }

    @Override
    protected int rank() {
        return 8;
    }
}
