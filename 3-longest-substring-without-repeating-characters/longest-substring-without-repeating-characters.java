class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            StringBuilder dup = new StringBuilder();
            for(int j = i;j<s.length();j++)
            {
                char ch = s.charAt(j);
                if(dup.length() == 0 || dup.indexOf(ch+"") == -1)
                {
                    dup.append(ch);
                }
                else break;
            }
            if(dup.length() > ans.length()) ans = dup;
        }
        return ans.length();
    }
}