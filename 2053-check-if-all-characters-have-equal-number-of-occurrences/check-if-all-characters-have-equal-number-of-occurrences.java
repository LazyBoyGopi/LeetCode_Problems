class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[]ar = new int[26];
        int highCount = 0;
        for(char ch : s.toCharArray()){
           int count = ++ar[ch-'a'];
           highCount = Math.max(highCount,count);
        }
        for(int value : ar){
            if(value != 0 && value != highCount) return false;
        }
        return true;
    }
}