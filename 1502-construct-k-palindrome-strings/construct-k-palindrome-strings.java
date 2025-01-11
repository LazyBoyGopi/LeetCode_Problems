class Solution {
    public boolean canConstruct(String s, int k) {
        int len = s.length();
        if(k > len) return false;
        if(k == len) return true;
        boolean[]map = new boolean[26];
        int countOfOdd = 0;
        for(int i=0;i<len;i++){
            int idx = s.charAt(i)-'a';
            map[idx] = !map[idx];
        }
        for(boolean val : map) if(val) countOfOdd++;
        return countOfOdd > k ? false : true;
    }
}