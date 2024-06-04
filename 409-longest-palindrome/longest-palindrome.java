class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap();
        int oddCount = 0;
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch) % 2 ==0 ) oddCount--;
            else oddCount++;
        }

        return oddCount > 1 ? s.length() -oddCount+1 : s.length();
    }
}