class Solution {
    public int minimumLength(String s) {
        int len = s.length();
        int[]freq = new int[26];
        for(int i=0;i<len;i++){
            int idx = s.charAt(i)-'a';
            freq[idx]++;
        }
        int newLength = 0;
        for(int i=0;i<26;i++){
            int curLen = freq[i];
            if(curLen > 2){
                if((curLen & 1) == 1)
                    newLength += 1;
                else 
                    newLength += 2;
            }
            else newLength += curLen;
        }
        return newLength;
    }
}