class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(count == k){
                sb.append('-');
                count = 0;
            }
            char ch = s.charAt(i);
            if(ch == '-') continue;
            
            sb.append(Character.toUpperCase(ch));
            count++;
        }
        if(sb.length() != 0 && sb.charAt(sb.length()-1) == '-') sb.setLength(sb.length()-1); 
        return sb.reverse().toString();
    }
}