class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1, len = s.length();
        char ch = s.charAt(0);
        sb.append(s.charAt(0));
        for(int i=1;i<len;i++){
            char cur = s.charAt(i);
            if(ch == cur){
                count++;
            }else{
                ch = cur;
                count = 1;
            }
            if(count < 3){
                sb.append(cur);
            }
        }
        return sb.toString();
    }
}