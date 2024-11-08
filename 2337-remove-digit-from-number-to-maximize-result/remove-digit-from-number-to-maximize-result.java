class Solution {
    private int isBigger(String str,String ans){
        int idx = 0, len = str.length();
        while(idx < len){
            char c1 = ans.charAt(idx);
            char c2 = str.charAt(idx);
            if(c1 != c2) return c1-c2;
            idx++;
        }
        return ans.length()-str.length();
    }
    public String removeDigit(String number, char digit) {
        String ans = new String("");
        for(int i=0;i<number.length();i++){
            if(number.charAt(i) == digit){
                String str = number.substring(0,i)+number.substring(i+1);
                if(ans.equals("") || isBigger(str,ans) < 0) ans = str;
            }
        }
        return ans;
    }
}