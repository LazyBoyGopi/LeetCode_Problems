class Solution {
    public boolean canConstruct(String s, int k) {
        int len = s.length();
        if(k > len) return false;
        if(k == len) return true;
        boolean[]map = new boolean[26];
        int countOfOdd = 0;
        for(int i=0;i<len;i++){
            boolean val = map[s.charAt(i)-'a'];
            map[s.charAt(i)-'a'] = !val;
        }
        for(boolean val : map) if(val) countOfOdd++;
        return countOfOdd > k ? false : true;
    }
}