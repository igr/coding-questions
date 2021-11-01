package google.lvl1;

public class CaesarCipher {

	public static String solution(final String cipher) {
		final int cipherLen = cipher.length();
		final char[] decrypted = new char[cipherLen];

		for (int i = 0; i < cipherLen; i++) {
			final int c = cipher.charAt(i);

			if (c >= 'a' && c <= 'z') {
				decrypted[i] = (char) ('z' - ((c + 7) % 26));
			} else {
				decrypted[i] = (char) c;
			}
		}

		return new String(decrypted);
	}

	// for testing purposes
	public static String encrypt(final String textToEncrypt) {
		final StringBuilder result = new StringBuilder();
		for (final char c : textToEncrypt.toCharArray()) {
			if ((int) c >= 'a' && (int) c <= 'z') {
				final int originalAlphabetPosition = c - 'z';
				final int newAlphabetPosition = (originalAlphabetPosition + 25) % 26;
				result.append((char) ('z' - newAlphabetPosition));

			} else {
				result.append(c);
			}
		}

		return result.toString();
	}

	public static void main(final String[] args) {
		final String expected = "wrw blf hvv ozhg mrtsg'h vkrhlwv?";
		final String input = "did you see last night's episode?";
		final var result = CaesarCipher.encrypt(input);
		System.out.println(expected.equals(result));

		System.out.println(input.equals(solution(result)));
	}

}
