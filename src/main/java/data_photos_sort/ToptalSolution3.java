package data_photos_sort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class ToptalSolution3 {

	public static void main(final String[] args) {
		new ToptalSolution3().solution("" +
				"photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
				"john.png, London, 2015-06-20 15:13:22\n" +
				"myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
				"Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
				"pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
				"BOB.jpg, London, 2015-08-05 00:02:03\n" +
				"notredame.png, Paris, 2015-09-01 12:00:00\n" +
				"me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
				"a.png, Warsaw, 2016-02-13 13:33:50\n" +
				"b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
				"c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
				"d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
				"e.png, Warsaw, 2016-01-02 09:49:09\n" +
				"f.png, Warsaw, 2016-01-02 10:55:32\n" +
				"g.jpg, Warsaw, 2016-02-29 22:13:11\n");
	}

	public static class Photo {
		public String name;
		public String ext;
		public String city;
		public LocalDateTime time;

		@Override
		public String toString() {
			return "Photo{" +
					"name='" + name + '\'' +
					", ext='" + ext + '\'' +
					", city='" + city + '\'' +
					", time=" + time +
					'}';
		}
	}

	public String solution(final String S) {
		final var photos = parseInput(S);

		// divide by cities
		final var photosPerCity = new HashMap<String, List<Photo>>();
		for (final Photo photo : photos) {
			final var list = photosPerCity.computeIfAbsent(photo.city, k -> new ArrayList<>());
			list.add(photo);
		}

		// sort by time
		for (final List<Photo> list : photosPerCity.values()) {
			list.sort(Comparator.comparing(o -> o.time));
		}

		// build new names
		final var result = new StringBuilder();
		for (final Photo photo : photos) {
			final var list = photosPerCity.get(photo.city);
			final int totalPerCity = list.size();
			final int indexOf = list.indexOf(photo) + 1;

			final var newName = newName(photo.city, indexOf, totalPerCity) + "." + photo.ext;
			result.append(newName);
			result.append("\n");
		}

		return result.toString();
	}

	private String newName(final String city, final int indexOf, final int total) {
		final int spaceLen = (int) Math.log10(total) + 1;
		if (spaceLen == 1) {
			return city + indexOf;
		}
		return city + String.format("%0" + spaceLen + "d", indexOf);
	}

	private final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	private List<Photo> parseInput(final String input) {
		final var lines = input.split("\n");
		final List<Photo> photos = new ArrayList<>(lines.length);
		for (final String line : lines) {
			if (line.isBlank()) {
				continue;
			}
			final var fields = line.split(",");

			final var photo = new Photo();

			photo.name = fields[0].trim();
			photo.ext = extensionOf(photo.name);
			photo.city = fields[1].trim();
			photo.time = LocalDateTime.parse(fields[2].trim(), DTF);

			photos.add(photo);
		}

		return photos;
	}

	private String extensionOf(final String name) {
		final int index = name.indexOf('.');
		return name.substring(index + 1);
	}
}
