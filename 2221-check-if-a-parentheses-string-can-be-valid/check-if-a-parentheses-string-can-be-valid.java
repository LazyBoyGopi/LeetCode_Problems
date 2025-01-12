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
        int length = s.length();

        // If length of string is odd, return false.
        if (length % 2 == 1) {
            return false;
        }
        int openBrackets = 0;
        int unlocked = 0;

        // Iterate through the string to handle '(' and ')'.
        for (int i = 0; i < length; i++) {
            if (locked.charAt(i) == '0') {
                unlocked++;
            } else if (s.charAt(i) == '(') {
                openBrackets++;
            } else if (s.charAt(i) == ')') {
                if (openBrackets > 0) {
                    openBrackets--;
                } else if (unlocked > 0) {
                    unlocked--;
                } else {
                    return false;
                }
            }
        }

        // Match remaining open brackets with unlocked characters.
        int balance = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                balance--;
                unlocked--;
            } else if (s.charAt(i) == '(') {
                balance++;
                openBrackets--;
            } else if (s.charAt(i) == ')') {
                balance--;
            }
            if (balance > 0) {
                return false;
            }
            if (unlocked == 0 && openBrackets == 0) {
                break;
            }
        }

        if (openBrackets > 0) {
            return false;
        }

        return true;
    }
}
