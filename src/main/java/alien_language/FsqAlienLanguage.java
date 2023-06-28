package alien_language;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

// solution does not throw exception on invalid input
public class FsqAlienLanguage {

    public static final String[] IN1 = {"bc", "bb", "bba", "bbc"};
    public static final String[] IN2 = {"bc", "bb", "bba", "bbc", "bbcz", "bbcb"};

    public static void main(String[] args) {
        System.out.println("Hello, world!");

        System.out.println(new FsqAlienLanguage().resolveOrder(IN1));
        System.out.println(new FsqAlienLanguage().resolveOrder(IN2));

        System.out.println(new FsqAlienLanguage().resolveOrder(Set.of(
                new OrderedPair('c', 'b'),
                new OrderedPair('a', 'b'),
                new OrderedPair('a', 'c')
        )));
        System.out.println(new FsqAlienLanguage().resolveOrder(Set.of(
                new OrderedPair('c', 'b'),
                new OrderedPair('a', 'c'),
                new OrderedPair('a', 'b')
        )));
        System.out.println(new FsqAlienLanguage().resolveOrder(Set.of(
                new OrderedPair('c', 'b'),
                new OrderedPair('a', 'c'),
                new OrderedPair('a', 'b'),
                new OrderedPair('z', 'c'),
                new OrderedPair('z', 'a'),
                new OrderedPair('z', 'b')
        )));
    }

    static class OrderedPair {
        char c1;
        char c2;

        public OrderedPair(char c1, char c2) {
            this.c1 = c1;
            this.c2 = c2;
        }
    }


    public String resolveOrder(String[] sortedWords) {
        Set<OrderedPair> pairs = new HashSet<>();
        for (int i = 0; i < sortedWords.length - 1; i++) {
            String word1 = sortedWords[i];
            String word2 = sortedWords[i + 1];

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    pairs.add(new OrderedPair(c1, c2));
                }
            }
        }
        return resolveOrder(pairs);
    }

    public String resolveOrder(Set<OrderedPair> pairs) {
        LinkedList<Character> alpha = new LinkedList<>();

        for (OrderedPair pair : pairs) {
            char c1 = pair.c1;
            char c2 = pair.c2;
            if (c1 != c2) {
                int index1 = alpha.indexOf(c1);
                int index2 = alpha.indexOf(c2);

                if (index1 == -1 && index2 == -1) {
                    // both not found
                    alpha.add(c1);
                    alpha.add(c2);
                } else if (index1 == -1) {
                    alpha.add(index2, c1);
                } else if (index2 == -1) {
                    alpha.add(index1 + 1, c2);
                } else {
                    if (index1 > index2) {
                        alpha.remove(index1);
                        alpha.add(index2, c1);
                    }
                }
            }
        }
        return alpha.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }


}
