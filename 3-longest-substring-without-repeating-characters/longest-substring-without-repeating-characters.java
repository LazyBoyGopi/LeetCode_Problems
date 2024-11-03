class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, len = s.length();
        Map<Character,Integer>map = new HashMap();
        int left = 0, right = 0;
        while(right < len){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                int idx = map.get(ch);
                if(idx >= left) left = idx+1;
            }
            maxLen = Math.max(maxLen,right-left+1);
            map.put(ch,right++);
        }
        return maxLen;
    }
}