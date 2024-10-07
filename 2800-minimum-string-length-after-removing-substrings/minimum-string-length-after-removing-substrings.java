class Solution {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            int sbLen = sb.length();
            if(sbLen > 0 && ((ch == 'B'&& sb.charAt(sbLen-1) == 'A') || (ch == 'D' && sb.charAt(sbLen-1) == 'C'))) sb.setLength(sbLen-1);
            else sb.append(ch);
        }
        return sb.length();
    }
}