/*
class Solution {
    public boolean canBeValid(String s, String locked) {
        int open = 0, closed = 0, len = s.length();
        System.out.println(len);
        for(int i=0;i<len;i++){
            char curCh = s.charAt(i);
            boolean canChange = locked.charAt(i) == '0';
            if(curCh == ')'){
                if(open > closed){
                    closed++;
                }else if(canChange){
                    open++;
                }else{
                    return false;
                }
            }else{
                if(open > closed){
                    if(canChange){
                        closed++;
                    }else{
                        open++;
                    }
                }else{
                    open++;
                }
            }
        }
        return open == closed;
    }
}

class Solution {
    public boolean canBeValid(String s, String locked) {
        Stack<Integer>stack = new Stack();
        int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch == ')' && !stack.isEmpty() && s.charAt(stack.peek()) =='('){
                stack.pop();
            }else{
                stack.push(i);
            }
        }
        System.out.println(stack);
        int open = 0, closed = 0;
        for(int idx : stack){
        System.out.println(idx);
            char curCh = s.charAt(idx);
            boolean canChanged = locked.charAt(idx) == '0';
            if(open > closed){
                if(curCh == '('){
                    if(canChanged){
                        closed++;
                    }else{
                        open++;
                    }
                }else{
                    closed++;
                }
            }else{
                if(curCh == '('){
                    open++;
                }else{
                    if(canChanged){
                        open++;
                    }else{
                        return false;
                    }
                }
            }
        }
        return open == closed;
    }
}

//-----------------------Brute Force----------------------(TLE)

class Solution {
    private boolean isPossible(String s, String locked,int idx,int open,int closed){
        if(idx >= s.length()){
            return (open == closed);
        }
        char ch = s.charAt(idx);
        boolean canChange = locked.charAt(idx) == '0';
        if(open > closed){
            if(canChange){
                if(isPossible(s,locked,idx+1,open+1,closed)) return true;
                if(isPossible(s,locked,idx+1,open,closed+1)) return true;
            }else{
                if(ch == ')'){
                    if(isPossible(s,locked,idx+1,open,closed+1)) return true;
                }else{
                    if(isPossible(s,locked,idx+1,open+1,closed)) return true;
                }
            }
        }else{
            if(canChange){
                if(isPossible(s,locked,idx+1,open+1,closed)) return true;
            }else{
                if(ch == ')') {
                    return false;
                }
                else{
                    if(isPossible(s,locked,idx+1,open+1,closed)) return true;
                }
            }
        }
        return false;
    }
    public boolean canBeValid(String s, String locked) {
        return isPossible(s,locked,0,0,0);
    }
}

*/



class Solution {
    public boolean canBeValid(String s, String locked) {
        int len = s.length();
        if((len & 1) == 1) return false;
        Stack<Integer>open = new Stack();
        Stack<Integer>lock = new Stack();
        for(int i=0;i<len;i++){
            char cur = s.charAt(i);
            if(locked.charAt(i) == '0') lock.push(i);
            else if(cur == '(') open.push(i);
            else if(cur == ')'){
                if(!open.isEmpty()) open.pop();
                else if(!lock.isEmpty()) lock.pop();
                else return false;
            }
        }
        while(!open.isEmpty() && !lock.isEmpty() && open.peek() < lock.peek()){
        open.pop();
        lock.pop();
        }
        return open.isEmpty();
    }
}
