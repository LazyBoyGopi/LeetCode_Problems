class Solution {
    public int minSwaps(String s) {
        Stack<Character>stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == ']' && stack.size()>0 && stack.peek() == '['){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return (stack.size()/2+1)/2;
    }
}