public class Solution {
    public int MinSwaps(string s) {
        Stack<char>stack = new Stack<char>();
        foreach(char ch in s.ToCharArray()){
            if(ch == ']' && stack.Count()>0 && stack.Peek() == '['){
                stack.Pop();
            }else{
                stack.Push(ch);
            }
        }
        return (stack.Count()/2+1)/2;
    }
}