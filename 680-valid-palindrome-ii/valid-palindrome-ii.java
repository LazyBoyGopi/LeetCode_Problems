class Solution {
    private boolean isPalindrome(int st,int end,String s)
    {
        while(st <= end){
            if(s.charAt(st) != s.charAt(end)) return false;
            st++;
            end--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int st = 0 , end = s.length()-1;
        while(st<=end){
            if(s.charAt(st) != s.charAt(end)){
                return isPalindrome(st+1,end,s) || isPalindrome(st,end-1,s); 
            }
            st++;
            end--;
    }
        return true;

    }
}