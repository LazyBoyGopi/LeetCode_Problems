class Solution {
    public int minOperations(String[] logs) {
        int len = 0;
        for(String str : logs){
            if(str.charAt(1) == '.') {
                if(len > 0) len--;
            }
            else if(str.charAt(0) != '.') len++;
        }
        return len;
    }
}