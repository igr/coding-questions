package txt_rear_palindrom;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class NagarroQuestion1 {

	public static void main(String[] args) {
		System.out.println(check("madma"));
		System.out.println(check("aaaabb"));
	}

	private static boolean check(final String str) {
		Map<Character, AtomicInteger> counter = new HashMap<>();
		str.chars().forEach(c -> {
			if (counter.containsKey((char) c)) {
				counter.get((char) c).incrementAndGet();
			} else {
				counter.put((char) c, new AtomicInteger(1));
			}
		});
		if (str.length() % 2 == 0) {
			return counter.values().stream().allMatch(i -> i.get() % 2 == 0);
		}
		return counter.values().stream().filter(i -> i.get() % 2 == 1).count() == 1;
	}
}
