class Solution {
    public String compressedString(String word) {
        char curCh = word.charAt(0);
        int len = word.length(), count = 1;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i < len; i++) {
            if (curCh == word.charAt(i))
                count++;
            else {
                int times = count / 9;
                int rem = count % 9;
                while (times > 0) {
                    ans.append('9');
                    ans.append((char) curCh);
                    times--;
                }
                if (rem != 0) {
                    ans.append(rem);
                    ans.append((char) curCh);
                }
                curCh = word.charAt(i);
                count = 1;
            }
        }
        if (count != 0) {
            int times = count / 9;
            int rem = count % 9;
            while (times > 0) {
                ans.append('9');
                ans.append((char) curCh);
                times--;
            }
            if (rem != 0) {
                ans.append(rem);
                ans.append((char) curCh);
            }
        }
        return ans.toString();
    }
}