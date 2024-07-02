class Solution {
    public String makeSmallestPalindrome(String s) {
        int len = s.length();
        char []ar = s.toCharArray();
        for(int i=0;i<=len/2;i++){
            if(ar[i] != ar[len-i-1]){
                if(ar[i] < ar[len-i-1]){
                    ar[len-i-1] = ar[i];
                }else{
                    ar[i] = ar[len-i-1];
                }
            }
        }
        return new String(ar);
    }
}