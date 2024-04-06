class Solution {
    public String minRemoveToMakeValid(String s) {
        char ar [] = s.toCharArray();
        int open = 0;
        for(int i=0;i<ar.length;i++)
        {
            char ch = ar[i];
            if(ch == '(') open++;
            else if(ch == ')')
            {
                if(open <= 0)
                ar[i] = ' ';
                else{
                    open--;
                }
            }
        }
        if(open > 0)
        {
            for(int i=ar.length-1;i>=0 && open > 0;i--)
            {
                if(ar[i] == '('){
                    ar[i] = ' ';
                    open--;
                }
            }
        }
        StringBuilder sb =  new StringBuilder();
        for(int i=0;i<ar.length;i++)
        {
            if(ar[i] != ' ') sb.append(ar[i]);
        }
        return sb.toString();
    }
}