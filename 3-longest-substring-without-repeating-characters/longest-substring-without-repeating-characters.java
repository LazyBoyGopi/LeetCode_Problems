class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, len = s.length(), maxLenWithoutRepeatingChar = 0;
        int[]map = new int[128];
        for(int i=0;i<len;i++){
            int idx = s.charAt(i);
            
            left = Math.max(left,map[idx]);
            maxLenWithoutRepeatingChar = Math.max(maxLenWithoutRepeatingChar,i-left+1);
            map[idx] = i+1;
        }
        return maxLenWithoutRepeatingChar;
    }
}