package txt_largest_sentence;

public class ToptalSolution1 {

	public static void main(final String[] args) {
		new ToptalSolution1().solution("We test codes. Give us a try?");
	}

	public int solution(final String S) {
		final var sentences = splitToSentences(S);
		int wordCounter = 0;
		for (final String sentence : sentences) {
			final var wordsCount = countWords(sentence);
			if (wordsCount > wordCounter) {
				wordCounter = wordsCount;
			}
		}
		return wordCounter;
	}

	private static String[] splitToSentences(final String text) {
		return text.split("[.?!]");
	}

	private static int countWords(final String text) {
		int count = 0;
		for (final String word : text.split(" ")) {
			if (word.isBlank()) {
				continue;
			}
			count++;
		}
		return count;
	}
}
