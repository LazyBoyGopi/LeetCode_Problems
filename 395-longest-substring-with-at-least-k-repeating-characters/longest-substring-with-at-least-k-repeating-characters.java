class Solution {
    public int longestSubstring(String s, int k) {
        int max = 0;
        for(int i=0;i<s.length();i++){
            Map<Character,Integer> map = new HashMap<>();
            for(int j=i;j<s.length();j++){
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
                boolean possible = true;
            for(int value : map.values()){
                if(value < k) {
                    possible = false;
                    break;
                }
            }
            if(possible) max  = Math.max(max,j-i+1);
            }
        }
        return max;
    }
}