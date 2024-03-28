class Solution {
    public int compress(char[] chars) {
        char last = chars[0];
        int count = 1, idx = 0;
        for (char j = 1; j < chars.length; j++) {
            char ch = chars[j];
            if (ch == last)
                count++;
            else {
                chars[idx++] = last;
                last = ch;
                if (count > 1) {
                    String s = String.valueOf(count);
                    for (int i = 0; i < s.length(); i++) {
                        chars[idx++] = s.charAt(i);
                    }
                    count = 1;
                }
            }
        }
        if (last == chars[chars.length - 1]) {
            chars[idx++] = last;
            if (count > 1) {
                String s = String.valueOf(count);
                for (int i = 0; i < s.length(); i++) {
                    chars[idx++] = s.charAt(i);
                }
            }
        }
        return idx;
    }
}