class Solution {
    public boolean canConstruct(String s, int k) {
        int len = s.length();
        if(k > len) return false;
        if(k == len) return true;
        int[]map = new int[26];
        for(int i=0;i<len;i++){
            map[s.charAt(i)-'a']++;
        }
        int countOfOdd = 0;
        for(int value : map) if((value & 1) == 1) countOfOdd++;
        return countOfOdd > k ? false : true;
    }
}