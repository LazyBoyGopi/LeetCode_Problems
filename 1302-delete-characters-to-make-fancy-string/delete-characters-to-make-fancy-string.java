class Solution {
    public String makeFancyString(String s) {
        char last = ' ' , preLast = ' ';
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(preLast == ' ' && last == ' '){
                sb.append(ch);
                last = ch;
            }
            else if(preLast == ' '){
                sb.append(ch);
                preLast = last;
                last = ch;
            }
            else if(!(ch == last && ch == preLast)){
                sb.append(ch);
                preLast = last;
                last = ch;
            }
        }
        return sb.toString();
    }
}