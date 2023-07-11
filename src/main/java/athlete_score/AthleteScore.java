package athlete_score;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class AthleteScore {

    public static void main(String[] args) {
        int[] score = { 10, 20, 21, 8, 25, 3, 50, 30, 1 };

        String[] answer = ranks(score);
        System.out.println(answer[0]);  // 4 place
        System.out.println(answer[5]);  // silver
        System.out.println(answer[8]);  // gold
    }

    private static class Athlete {
        public final int score;
        public final int index;
        public int rank;
        public Athlete(int index, int score) {
            this.index = index;
            this.score = score;
        }

        public String rank() {
            switch (rank) {
                case 1: return "Gold";
                case 2: return "Silver";
                case 3: return "Bronze";
                default: return rank + " place";
            }
        }
    }

    private static String[] ranks(int[] score) {
        Athlete[] sorted = IntStream
                .range(0, score.length)
                .mapToObj(index -> new Athlete(index, score[index]))
                .sorted(Comparator.comparingInt(a -> a.score))
                .toArray(Athlete[]::new);

        IntStream
                .range(0, sorted.length)
                .forEach(index -> sorted[index].rank = index + 1);

        return Arrays.stream(sorted)
                .sorted(Comparator.comparingInt(a -> a.index))
                .map(Athlete::rank)
                .toArray(String[]::new);
    }

}
