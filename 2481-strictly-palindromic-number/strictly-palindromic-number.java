class Solution {
    String baseSystem(int n,int base)
    {
        StringBuilder sb = new StringBuilder();
        int cur = n;
        while(cur >= base)
        {
            sb.append(cur%base);
            cur /= base;
        }
        sb.append(cur);
        return sb.toString();
    }
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
    public boolean isStrictlyPalindromic(int n) {
        for(int i=2;i<=n-2;i++)
        {
            if(!isPalindrome(baseSystem(n,i))) return false;
        }
        return true;
    }
}