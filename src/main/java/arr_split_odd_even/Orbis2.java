package arr_split_odd_even;

// JUST A SCKETCH
public class Orbis2 {

	void splitOddAndEvenNumbers(final int[] a, final int[] b) {
		int pointerA = 0;
		int pointerB = 0;

		while (true) {
			final int elementA = a[pointerA];
			final int elementB = b[pointerB];

			if (isOdd(elementA)) {
				if (isEven(elementB)) {
					pointerA++;
					pointerB++;
					continue;
				}

				pointerA++;
			} else {
				if (isOdd(elementB)) {
					// switch
					pointerA++;
					pointerB++;
					continue;
				}
				pointerB++;
			}
		}
	}



	private boolean isEven(final int element) {
		return element % 2 == 0;
	}

	private boolean isOdd(final int element) {
		return element % 2 == 1;
	}

	public static void main(final String[] args) {
		final int[] a = {1, 4, 7, 8, 10};
		final int[] b = {2, 3, 5, 6, 9};

	}
}
