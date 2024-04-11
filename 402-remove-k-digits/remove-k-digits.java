class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(char ch : num.toCharArray())
        {
            if(stack.isEmpty() && ch != '0')
            {
                stack.push(ch);
            }
            else{
                while(!stack.isEmpty() && stack.peek() > ch && k > 0)
                {
                    stack.pop();
                    k--;
                }
                if(stack.isEmpty())
                {
                    if(ch != '0') stack.push(ch);
                }
                else  stack.push(ch);
            }
        }
        if(k > 0)
        {
            while(!stack.isEmpty() && k > 0)
            {
                stack.pop();
                k--;
            }
            if(stack.isEmpty()) return "0";
        }
        if(stack.size() == 0) return "0";
        char ch [] = new char[stack.size()];
        for(int i=ch.length-1;i>=0;i--)
        {
            ch[i] = stack.pop();
        }
        return new String(ch);
    }
}