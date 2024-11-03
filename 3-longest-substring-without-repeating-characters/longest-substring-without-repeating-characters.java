class Solution {
    public int lengthOfLongestSubstring(String s) {
        int []hash = new int[128];
        Arrays.fill(hash,-1);
        int len = s.length(), max = 0, left = 0, right = 0;
        while(right < len){
            int ch = s.charAt(right);
            if(hash[ch] != -1){
                int idx = hash[ch];
                if(idx >= left) left = idx+1;
            }
            max = Math.max(max,right-left+1);
            hash[ch] = right++;
        }
        return max;
    }
}