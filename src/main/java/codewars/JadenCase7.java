package codewars;

public class JadenCase7 {
	public String toJadenCase(String phrase) {
		if (phrase == null) {
			return null;
		}
		if (phrase.length() == 0) {
			return null;
		}
		String[] parts = phrase.split(" ");

		StringBuilder sb = new StringBuilder();
		for (String part: parts) {
			sb.append(Character.toUpperCase(part.charAt(0)))
					.append(part.substring(1).toLowerCase())
					.append(' ');
		}
		return sb.toString().trim();
	}

}