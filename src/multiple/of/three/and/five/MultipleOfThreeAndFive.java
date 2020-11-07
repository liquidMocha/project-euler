package multiple.of.three.and.five;

import java.util.ArrayList;
import java.util.List;

public class MultipleOfThreeAndFive {
    public static void main(String[] args) {
        List<Integer> multiples = new ArrayList<>();
        int sum = 0;

        int multiplier = 1;
        while (3 * multiplier < 1000) {
            int multipleOfThree = 3 * multiplier;
            sum += multipleOfThree;
            multiples.add(3 * multiplier);
            multiplier++;
        }

        multiplier = 1;
        while (5 * multiplier < 1000) {
            int multipleOfFive = 5 * multiplier;
            if (!multiples.contains(multipleOfFive)) {
                sum += multipleOfFive;
            }
            multiplier++;
        }

        System.out.println("Sum: " + sum);
    }
}
