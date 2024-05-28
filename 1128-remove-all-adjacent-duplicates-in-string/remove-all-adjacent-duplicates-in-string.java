class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char last = ' ';
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == ch){
            while(!stack.isEmpty() && ch == stack.peek()){
                last = stack.pop();
            }
            }
            else
            {
                last = ch;
                stack.push(ch);
            }
        }
        StringBuilder sb =  new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}