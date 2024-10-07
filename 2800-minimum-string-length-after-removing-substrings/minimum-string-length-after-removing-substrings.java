class Solution {
    public int minLength(String s) {
        Stack<Character>stack = new Stack();
        int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && ch == 'B' && stack.peek() == 'A'){
                stack.pop();
            }else if(!stack.isEmpty() && ch == 'D' && stack.peek() == 'C'){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.size();
    }
}