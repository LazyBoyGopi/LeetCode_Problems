class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        int includeIdx = 0, len = s.length(), maxLenWithoutRepeatingChar = 1, firstCount = 0, firstChIdx = s.charAt(0);
        int[]map = new int[128];
        for(int i=0;i<len;i++){
            int idx = s.charAt(i), lastChIdx = map[idx];
            map[idx] = i;
            if(firstChIdx == idx){
                firstCount++;
            }
            if(lastChIdx == 0 && (firstChIdx != s.charAt(i) || firstCount == 1))
                lastChIdx = -1;
            if(lastChIdx != -1){
                includeIdx = Math.max(includeIdx,lastChIdx+1);
            }
            maxLenWithoutRepeatingChar = Math.max(maxLenWithoutRepeatingChar,i-includeIdx+1);
        }
        return maxLenWithoutRepeatingChar;
    }
}