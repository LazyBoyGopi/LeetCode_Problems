class Solution {
    private String backSpace(String s)
    {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray())
        {
            if(ch != '#') sb.append(ch);
            else if(sb.length() != 0) sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
    public boolean backspaceCompare(String s, String t) {
        return backSpace(s).equals(backSpace(t));
        // Stack<Character> s1 = new Stack<>();
        // Stack<Character> t1 = new Stack<>();
        // int i;
        // for(i=0;i<s.length();i++)
        // {
        //     char ch = s.charAt(i);
        //     if(ch == '#'){
        //         if(!s1.isEmpty())
        //         {
        //             s1.pop();
        //         }
        //     }
        //     else{
        //         s1.push(ch);
        //     }
        // }
        // for(i=0;i<t.length();i++)
        // {
        //     char ch = t.charAt(i);
        //     if(ch == '#'){
        //         if(!t1.isEmpty())
        //         {
        //             t1.pop();
        //         }
        //     }
        //     else{
        //         t1.push(ch);
        //     }
        // }
        // while(!s1.isEmpty() && !t1.isEmpty())
        // {
        //     if(s1.pop() != t1.pop()) return false;
        // }
        // return s1.isEmpty() && t1.isEmpty();
    }
}