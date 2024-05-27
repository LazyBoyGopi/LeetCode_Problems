class Solution {
    private boolean isPossible(int freq[], int options) {
        Set<Integer> set = new HashSet<>();
        for (int ele : freq) {
            while (true) {
                if (ele != 0 && set.contains(ele)) {
                    if (options == 0)
                        return false;
                    ele--;
                    options--;
                }
                else {
                    set.add(ele);
                    break;
                }
            }
        }
        return options >= 0;
    }

    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int st = 0, end = s.length();
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (isPossible(freq, mid)) {
                end = mid - 1;
            } else
                st = mid + 1;
        }
        return end+1;
    }
}