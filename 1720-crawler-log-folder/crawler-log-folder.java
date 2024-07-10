class Solution {
    public int minOperations(String[] logs) {
        int len = 0;
        for(String str : logs){
            switch(str){
                case "../" : {
                    if(len > 0) len--;
                }
                break;
                case "./" : 
                break;
                default : len++; 
            }
        }
        return len;
    }
}