class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch == '-') continue;
            if(count == k){
                sb.insert(0,'-');
                count = 0;
            }
            sb.insert(0,(ch>='a' && ch <= 'z') ? (char)(ch-32) : ch);
            count++;
        }
        return sb.toString();
    }
}