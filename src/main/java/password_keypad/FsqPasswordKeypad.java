package password_keypad;

public class FsqPasswordKeypad {

    public static void main(String[] args) {
        System.out.println(entryTime("15ebb", "0123456789abcdef")); // 4
    }

    private static class Key {
        final int x;
        final int y;
        final char value;

        public Key(int x, int y, char value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    private static int entryTime(String password, String keypad) {
        final Key[] keys = new Key[keypad.length()];
        for (int i = 0; i < keypad.length(); i++) {
            keys[i] = new Key(i % 4, i / 4, keypad.charAt(i));
        }

        int time = 0;
        char[] chars = password.toCharArray();
        Key previous = keyOf(keys, chars[0]);
        for (int i = 1; i < chars.length; i++) {
            Key current = keyOf(keys, chars[i]);
            int dist = distance(previous, current);
            time += dist;
            previous = current;
        }
        return time;
    }

    private static int distance(Key from, Key to) {
        return Math.max(Math.abs(from.x - to.x), Math.abs(from.y - to.y));
    }

    private static Key keyOf(Key[] keys, char c) {
        for (Key key : keys) {
            if (key.value == c) {
                return key;
            }
        }
        throw new IllegalArgumentException("Key not found: " + c);
    }
}
