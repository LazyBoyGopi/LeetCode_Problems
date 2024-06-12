class Solution {
    private boolean recu(int st,int end,String s,int count)
    {
        if(st > end) return true;
        if(s.charAt(st) == s.charAt(end)){
            return recu(st+1,end-1,s,count);
        }
        else if(count == 0){
            if(recu(st+1,end,s,count+1) || recu(st,end-1,s,count+1)) return true;
            else return false;
        }
        else return false;
    }
    public boolean validPalindrome(String s) {
        return recu(0,s.length()-1,s,0);
    }
}