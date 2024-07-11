class Solution {
    private void reverse(int st,int end,char ar[]){
        while(st <= end){
            char ch = ar[st];
            ar[st++] = ar[end];
            ar[end--] = ch;
        }
    }
    public String reverseParentheses(String s) {
        Stack<Integer>stack = new Stack<>();
        char ar[] = s.toCharArray();
        for(int i=0;i<ar.length;i++){
            if(ar[i] == '(') stack.push(i);
            else if(ar[i] == ')'){
                reverse(stack.pop(),i,ar);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : ar){
            if(ch == '(' || ch == ')') ;
            else sb.append(ch);
        }
        return sb.toString();
    }
}