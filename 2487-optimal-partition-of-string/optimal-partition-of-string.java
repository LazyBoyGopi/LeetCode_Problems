class Solution {
    public int partitionString(String s) {
        boolean[]ar = new boolean[26];
        int count = 0, len = s.length();
        for(int i=0;i<len;i++){
            int ch = s.charAt(i)-'a';
            if(ar[ch]){
                count++;
                ar = new boolean[26];
            }
            ar[ch] = true;
        }
        return count+1;
    }
}