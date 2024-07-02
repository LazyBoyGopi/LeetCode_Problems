class Solution {
    public String makeSmallestPalindrome(String s) {
        int left = 0 , right = s.length()-1;
        char []ar = s.toCharArray();
        while(left < right){
            ar[left] = (char)Math.min(s.charAt(left),s.charAt(right));
            ar[right--] = ar[left++];
        }
        return new String(ar);
    }
}