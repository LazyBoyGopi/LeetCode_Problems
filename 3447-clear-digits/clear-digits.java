class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(!(ch >= '0' && ch <= '9')){
                sb.append(ch);
            }else if(sb.length() > 0){
                sb.setLength(sb.length()-1);
            }
        }
        return sb.toString();
    }
}