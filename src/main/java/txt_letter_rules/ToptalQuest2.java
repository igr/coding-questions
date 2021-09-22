package txt_letter_rules;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ToptalQuest2 {

	public static void main(final String[] args) {
		final var q = new ToptalQuest2();

		System.out.println(q.findWord("I>N", "A>I", "P>A", "S>P"));
		System.out.println(q.findWord("U>N", "G>A", "R>Y", "H>U", "N>G", "A>R"));
		System.out.println(q.findWord("I>F", "W>I", "S>W", "F>T"));
		System.out.println(q.findWord("R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G"));
		System.out.println(q.findWord("W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T"));
	}

	public String findWord(final String... rules) {
		final var listOfRules = Arrays
				.stream(rules)
				.map(this::createRule)
				.collect(Collectors.toList());

		Rule first = listOfRules.remove(0);
		Rule last = first;

		while (!listOfRules.isEmpty()) {

			int ndx = findNextRule(last, listOfRules);
			if (ndx != -1) {
				final var next = listOfRules.remove(ndx);
				last.next = next;
				last = next;
				continue;
			}

			ndx = findPrevRule(first, listOfRules);
			if (ndx != -1) {
				final var prev = listOfRules.remove(ndx);
				first.prev = prev;
				prev.next = first;
				first = prev;
			}
		}
		final var sb = new StringBuilder();
		while (first != null) {
			sb.append(first.left);
			first = first.next;
		}
		sb.append(last.right);
		return sb.toString();
	}

	private int findNextRule(final Rule rule, final List<Rule> listOfRules) {
		for (int i = 0; i < listOfRules.size(); i++) {
			final Rule r = listOfRules.get(i);
			if (Objects.equals(rule.right, r.left)) {
				return i;
			}
		}
		return -1;
	}

	private int findPrevRule(final Rule rule, final List<Rule> listOfRules) {
		for (int i = 0; i < listOfRules.size(); i++) {
			final Rule r = listOfRules.get(i);
			if (Objects.equals(rule.left, r.right)) {
				return i;
			}
		}
		return -1;
	}

	public static class Rule {
		public final String left;
		public final String right;
		public Rule next;
		public Rule prev;

		public Rule(final String left, final String right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return left + '>' + right;
		}
	}

	public Rule createRule(final String rule) {
		final var split = rule.split(">");
		return new Rule(split[0], split[1]);
	}
}
