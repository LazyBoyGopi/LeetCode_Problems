class Solution {
    private boolean isBigger(String str,String ans){
        if(ans.equals("")) return true;
        int idx = 0, len = str.length();
        while(idx < len){
            if(str.charAt(idx) < ans.charAt(idx)) return true;
            idx++;
        }
        return false;
    }
    public String removeDigit(String number, char digit) {
        String ans = new String("");
        for(int i=0;i<number.length();i++){
            if(number.charAt(i) == digit){
                String str = new StringBuilder(number).deleteCharAt(i).toString();
                if(ans.equals("") || ans.compareTo(str) < 0) ans = str;
            }
        }
        return ans;
    }
}