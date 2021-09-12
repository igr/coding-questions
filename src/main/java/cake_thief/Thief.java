package cake_thief;

import java.util.Arrays;

public class Thief {

	public static void main(final String[] args) {
		final CakeType[] cakeTypes = new CakeType[]{
				new CakeType(7, 160),
				new CakeType(3, 90),
				new CakeType(2, 15),
		};

		final int capacity = 20;
		maxDuffelBagValue(cakeTypes, capacity);
	}

	public static void maxDuffelBagValue(final CakeType[] cakeTypes, final int capacity) {
		final int smallestCakeNdx = indexOfSmallestWeightedCake(cakeTypes);
		final int maxItems = capacity / smallestCakeNdx + 1;
		final int[] arr = new int[cakeTypes.length];
		int maxPrice = 0;
		final int[] maxArr = new int[cakeTypes.length];;

		while (true) {
			if (!nextStep(arr, maxItems)) {
				break;
			}
			final int weight = calcWeight(cakeTypes, arr);
			if (weight > capacity) {
				continue;
			}
			final int price = calcPrice(cakeTypes, arr);
			if (price > maxPrice) {
				maxPrice = price;
			}
		}

		System.out.println(Arrays.toString(maxArr));
		System.out.println(calcWeight(cakeTypes, maxArr));
		System.out.println(calcPrice(cakeTypes, maxArr));
	}

	private static int calcWeight(final CakeType[] cakeTypes, final int[] arr) {
		int weight = 0;
		for (int i = 0; i < cakeTypes.length; i++) {
			final CakeType cakeType = cakeTypes[i];
			weight += cakeType.weight * arr[i];
		}
		return weight;
	}

	private static int calcPrice(final CakeType[] cakeTypes, final int[] arr) {
		int price = 0;
		for (int i = 0; i < cakeTypes.length; i++) {
			final CakeType cakeType = cakeTypes[i];
			price += cakeType.value * arr[i];
		}
		return price;
	}

	private static boolean nextStep(final int[] arr, final int maxItems) {
		int index = arr.length - 1;

		while (index >= 0) {
			arr[index]++;
			if (arr[index] >= maxItems) {
				arr[index] = 0;
				index--;
				continue;
			}
			return true;
		}
		return false;
	}

	private static int indexOfSmallestWeightedCake(final CakeType[] cakeTypes) {
		int smallestWeight = Integer.MAX_VALUE;
		int smallNdx = -1;

		for (int i = 0; i < cakeTypes.length; i++) {
			final CakeType cakeType = cakeTypes[i];
			if (cakeType.weight < smallestWeight) {
				smallestWeight = cakeType.weight;
				smallNdx = i;
			}
		}
		return smallNdx;
	}

}
