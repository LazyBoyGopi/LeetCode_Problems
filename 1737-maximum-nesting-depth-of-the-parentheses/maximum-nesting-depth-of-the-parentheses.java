class Solution {
    public int maxDepth(String s) {
        int open = 0;
        int max = 0;
        for(char ch : s.toCharArray())
        {
            if(ch == '(')
            {
                open++;
            }
            else if(ch == ')')
            {
                max = Math.max(open,max);
                open--;
            }
        }
        return max;
    }
}