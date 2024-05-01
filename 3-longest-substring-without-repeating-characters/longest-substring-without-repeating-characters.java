class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        int[]hash = new int[256];
        Arrays.fill(hash,-1);
        int left = 0 , right = 0 , max = 0 , len = s.length();
        while(right < len)
        {
            char ch = s.charAt(right);
            int idx = hash[ch];
            if(idx >= 0 && idx >= left) left = idx+1;
            hash[ch] = right;
            max = Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}