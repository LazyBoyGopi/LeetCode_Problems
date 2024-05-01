class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int left = 0 , right = 0 , max = 0;
        while(right < s.length())
        {
            char ch = s.charAt(right);
            if(map.containsKey(ch))
            {
                int idx = map.get(ch);
                if(idx >= left) left = idx+1;
            }
            map.put(ch,right);
            max = Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}