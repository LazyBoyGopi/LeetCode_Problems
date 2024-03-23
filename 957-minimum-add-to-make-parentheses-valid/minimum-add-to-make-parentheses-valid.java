class Solution {
    public int minAddToMakeValid(String s) {
       int open = 0 , count = 0;
       for(char ch : s.toCharArray())
       {
        if(ch == '(') open++;
        else {
            if(open > 0) open--;
            else count++;
        }
       }
       return count + open;
    }
}