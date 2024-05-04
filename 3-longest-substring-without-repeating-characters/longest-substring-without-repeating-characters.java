class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[128];
        Arrays.fill(hash,-1);
        int left = 0 , right = 0 , max = 0;
        for(char ch : s.toCharArray())
        {
            int idx = hash[ch];
            if(idx >= 0 && idx >= left) left = idx+1;
            hash[ch] = right;
            max = Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}