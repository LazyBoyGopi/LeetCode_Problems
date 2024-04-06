class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch == '(') {
                sb.append(ch);
                open++;
            }
            else if(ch == ')')
            {
                if(open <= 0)
                {
                    
                }
                else{
                    sb.append(ch);
                    open--;
                }
            }
            else{
                sb.append(ch);
            }
        }
        if(open > 0)
        {
            for(int i=sb.length()-1;i>=0 && open > 0;i--)
            {
                if(sb.charAt(i) == '(')
                {
                    sb.deleteCharAt(i);
                    open--;
                }
            }
        }
        return sb.toString();
    }
}