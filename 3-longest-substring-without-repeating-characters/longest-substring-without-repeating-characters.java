class Solution {
    public int lengthOfLongestSubstring(String s) {
        int includeIdx = 0, len = s.length(), maxLenWithRepeatingChar = 0;
        int[]map = new int[256];
        Arrays.fill(map,-1);
        for(int i=0;i<len;i++){
            int idx = s.charAt(i), lastChIdx = map[idx];
            map[idx] = i;
            if(lastChIdx != -1){
                includeIdx = Math.max(includeIdx,lastChIdx+1);
            }
            maxLenWithRepeatingChar = Math.max(maxLenWithRepeatingChar,i-includeIdx+1);
        }
        return maxLenWithRepeatingChar;
    }
}