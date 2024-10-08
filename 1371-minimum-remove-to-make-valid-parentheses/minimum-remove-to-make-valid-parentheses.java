class Solution {
    public String minRemoveToMakeValid(String s) {
        int opening = 0, closing = 0, len = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                if(opening > 0){
                    sb.append(ch);
                    opening--;
                }else closing++;
            }else if(ch == '('){
                opening++;
                sb.append(ch);
            }else{
                sb.append(ch);
            }
        }
        if(opening > 0){
            for(int i=sb.length()-1;i>=0 && opening > 0;i--){
                if(sb.charAt(i) =='('){
                    opening--;
                    sb.deleteCharAt(i);
                }
            }
        }
        return sb.toString();
    }
}