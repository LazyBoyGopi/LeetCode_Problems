class Solution {
    public boolean canConstruct(String s, int k) {
        int len = s.length();
        if(k > len) return false;
        if(k == len) return true;
        int[]map = new int[26];
        int countOfOdd = 0;

        for(int i=0;i<len;i++){
            int idx = s.charAt(i)-'a';
            map[idx]++;
            if((map[idx] & 1) == 1) countOfOdd++;
            else countOfOdd--;
        }
        return countOfOdd > k ? false : true;
    }
}