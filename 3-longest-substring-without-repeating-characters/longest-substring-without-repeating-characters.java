class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        int hash[] = new int[128];
        Arrays.fill(hash,-1);
        int left = 0 , max = 0 ;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            int idx = hash[ch];
            if(idx >= 0 && idx >= left) left = idx+1;
            hash[ch] = i;
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}