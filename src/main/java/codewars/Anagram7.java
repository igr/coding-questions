package codewars;

public class Anagram7 {

	public static boolean isAnagram(String test, String original) {
		if (test.length() != original.length()) {
			return false;
		}
		boolean[] originalMatched = new boolean[original.length()];
		original = original.toLowerCase();

		nexta:
		for (int i = 0; i < test.length(); i++) {
			char a = Character.toLowerCase(test.charAt(i));

			for (int j = 0; j < original.length(); j++) {
				if (originalMatched[j]) {
					continue;
				}
				char b = original.charAt(j);
				if (a == b) {
					originalMatched[j] = true;
					continue nexta;
				}
			}
			return false;
		}
		return true;
	}
}
