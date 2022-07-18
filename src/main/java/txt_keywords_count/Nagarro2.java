package txt_keywords_count;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Nagarro2 {

	public static void main(String[] args) {
		var a = run(
				2,
				new String[]{"nagarro", "the", "website"},
				new String[]{
						"nagarro provides the best services in the city",
						"nagarro has awesome website",
						"Best services provided by nagarro, everyone should use nagarro",
				});

		System.out.println(Arrays.asList(a));
	}

	private static String[] run(int x, String[] keywords, String[] texts) {
		var keywordsFrequency = new HashMap<String, AtomicInteger>();

		Arrays
				.stream(texts)
				.flatMap(t -> Arrays.stream(t.split(" ")))
				.filter(w -> Arrays.asList(keywords).contains(w))
				.forEach(w -> keywordsFrequency.computeIfAbsent(w, k -> new AtomicInteger()).incrementAndGet());

		return keywordsFrequency.entrySet()
				.stream()
				.sorted((o1, o2) -> o2.getValue().get() - o1.getValue().get())
				.map(Map.Entry::getKey)
				.limit(x)
				.toArray(String[]::new);
	}
}
