class Solution {
    public String clearDigits(String s) {
        Stack<Integer>stack = new Stack();
        char ar[] = s.toCharArray();
        int len = ar.length;
        for(int i=0;i<len;i++){
            char ch = ar[i];
            if(!(ch >= '0' && ch <= '9')){
                stack.push(i);
            }else{
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int idx : stack){
            sb.append(ar[idx]);
        }
        return sb.toString();
    }
}