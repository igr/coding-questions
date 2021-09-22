package domino;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ToptalQuest1 {

	public static void main(final String[] args) {
		final ToptalQuest1 q1 = new ToptalQuest1();

		System.out.println(q1.domino("6-3"));           // 1
		System.out.println(q1.domino("1-2,1-2"));       // 1
		System.out.println(q1.domino("1-1,3-5,5-2,2-3,2-4"));   // 3
		System.out.println(q1.domino("3-2,2-1,1-4,4-4,5-4,4-2,2-1"));   // 4
		System.out.println(q1.domino("5-5,5-5,4-4,5-5,5-5,5-5,5-5,5-5,5-5,5-5"));       // 7
		System.out.println(q1.domino("1-1,3-5,5-5,5-4,4-2,1-3"));       // 4
	}

	private static class Domino {
		public Domino(final int left, final int right) {
			this.left = left;
			this.right = right;
		}

		public final int left;
		public final int right;
	}

	private int domino(final String input) {
		final List<Domino> dominoes = Arrays
				.stream(input.split(","))
				.map(this::makeDomino)
				.collect(Collectors.toList());

		int chainCount = 1;
		int lastMax = 1;
		Domino prevDomino = dominoes.get(0);

		for (int i = 1; i < dominoes.size(); i++) {
			final Domino currentDomino = dominoes.get(i);

			if (dominoMatchesThePrev(prevDomino, currentDomino)) {
				chainCount++;
				if (chainCount > lastMax) {
					lastMax = chainCount;
				}
			} else {
				chainCount = 1;
			}

			prevDomino = currentDomino;
		}
		return lastMax;
	}

	private boolean dominoMatchesThePrev(final Domino prevDomino, final Domino currentDomino) {
		return currentDomino.left == prevDomino.right;
	}

	private Domino makeDomino(final String dominoString) {
		final String[] numbers = dominoString.split("-");
		return new Domino(
				Integer.parseInt(numbers[0]),
				Integer.parseInt(numbers[1])
		);
	}

}
