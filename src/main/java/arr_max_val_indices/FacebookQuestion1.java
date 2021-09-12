package arr_max_val_indices;

import java.util.Random;

public class FacebookQuestion1 {
	public static void main(final String[] args) {
		System.out.println(findMaxIndexValue(new int[] {1,2,3,4,5}));      /// 4
		System.out.println(findMaxIndexValue(new int[] {1,5,3,4,4,5}));   // 1 or 5
	}

	public static int findMaxIndexValue(final int[] array) {
		int max = Integer.MIN_VALUE;
		int count = 0;

		for (final int element : array) {
			if (element > max) {
				max = element;
				count = 0;
			}
			if (max == element) {
				count++;
			}
		}

		final int rndResult = new Random().nextInt(count);

		int order = 0;
		for (int i = 0; i < array.length; i++) {
			if (max == array[i]) {
				if (order == rndResult) {
					return i;
				}
				order++;
			}
		}

		return -1;
	}
}
