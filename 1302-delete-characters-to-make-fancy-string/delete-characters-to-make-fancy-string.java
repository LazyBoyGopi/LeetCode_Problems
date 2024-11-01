class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1, len = s.length();
        char cur = s.charAt(0), ch = cur;
        sb.append(ch);
        for(int i=1;i<len;i++){
            cur = s.charAt(i);
            if(ch == cur)
                count++;
            else
                count = 1;
            if(count < 3)
                sb.append(cur);
            ch = cur;
        }
        return sb.toString();
    }
}