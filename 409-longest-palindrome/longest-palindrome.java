class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int oddCount = 0;
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int value : map.values()) if(value % 2 == 1) oddCount++;
        return oddCount > 1 ? s.length()-oddCount+1 : s.length();
    }
}