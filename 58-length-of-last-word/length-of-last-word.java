class Solution {
    public int lengthOfLastWord(String s) {
        int i;
        for(i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i) != ' ') break;
        }
        int j;
        for(j=i;j>=0;j--)
        {
            if(s.charAt(j) == ' ') return i-j;
        }
        return i-j;
    }
}