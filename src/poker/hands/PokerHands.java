package poker.hands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.toList;
import static poker.hands.HandFactory.createHand;

public class PokerHands {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("/home/hanchen/Documents/workspace/project-euler/src/poker/hands/poker-hands.txt"))) {
            int player1Wins = reader.lines().reduce(0, (sum, newLine) -> {
                Hand player1sHand = player1sHand(newLine);
                Hand player2sHand = player2sHand(newLine);
                if (player1sHand.higherThan(player2sHand)) {
                    sum++;
                }
                return sum;
            }, Integer::sum);

            System.out.println(player1Wins);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static Hand player1sHand(String line) {
        String[] player1sHand = line.substring(0, 14).split(" ");
        return createHand(Arrays.stream(player1sHand)
                .map(cardString -> new Card(cardString.charAt(0), cardString.charAt(1)))
                .collect(toList()));
    }

    static Hand player2sHand(String line) {
        String[] player2sHand = line.substring(15).split(" ");
        return createHand(Arrays.stream(player2sHand)
                .map(cardString -> new Card(cardString.charAt(0), cardString.charAt(1)))
                .collect(toList()));
    }
}

