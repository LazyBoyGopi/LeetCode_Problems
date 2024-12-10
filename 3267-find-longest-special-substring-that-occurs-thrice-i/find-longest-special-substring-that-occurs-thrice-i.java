import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumLength(String s) {
        int ans = -1;
        Map<Pair, Integer> map = new HashMap<>(); // Map of (character, size) -> count
        int n = s.length();
        char[] chars = s.toCharArray();

        // First pass: Populate the map with frequencies of contiguous substrings
        map.put(new Pair(chars[0], 1), 1);
        int currFreq = 1;
        for (int i = 1; i < n; i++) {
            if (chars[i] == chars[i - 1]) {
                currFreq++;
                map.put(new Pair(chars[i], currFreq), map.getOrDefault(new Pair(chars[i], currFreq), 0) + 1);
            } else {
                currFreq = 1;
                map.put(new Pair(chars[i], currFreq), map.getOrDefault(new Pair(chars[i], currFreq), 0) + 1);
            }
        }

        // Second pass: Find the maximum length of a substring satisfying the condition
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = n; i > 0; i--) {
                Pair key = new Pair(c, i);
                if (map.containsKey(key)) {
                    if (map.get(key) >= 3) {
                        ans = Math.max(ans, i);
                    }
                    Pair smallerKey = new Pair(c, i - 1);
                    map.put(smallerKey, map.getOrDefault(smallerKey, 0) + map.get(key));
                }
            }
        }

        return ans;
    }

    // Helper class for the (character, size) pair
    static class Pair {
        char c;
        int size;

        Pair(char c, int size) {
            this.c = c;
            this.size = size;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return c == pair.c && size == pair.size;
        }

        @Override
        public int hashCode() {
            int result = Character.hashCode(c);
            result = 31 * result + Integer.hashCode(size);
            return result;
        }
    }

    // Main method for testing
}
