class Solution {
    boolean isPalindrome(String s)
    {
        int st = 0 , end = s.length()-1;
        while(st <= end)
        {
            if(s.charAt(st) != s.charAt(end)) return false;
            st++;
            end--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int len = s.length() , ansLen = 0;
        String ans = "" ; 
       for(int i=0;i<len;i++)
       {
           for(int j=i+1;j<=len;j++)
           {
               if(ansLen < j-i+1 && isPalindrome(s.substring(i,j)))
               {
                   ansLen = j-i+1;
                   ans = s.substring(i,j);
               }
           }
       }
        return ans;
    }
}