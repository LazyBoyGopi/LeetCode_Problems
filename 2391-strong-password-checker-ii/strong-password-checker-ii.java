class Solution {
    public boolean strongPasswordCheckerII(String password) {
        int len = password.length();
        if(len < 8) return false;
        boolean lc = false, uc = false, d = false, spl = false;
        for(int i=0;i<len;i++){
            char ch = password.charAt(i);
            if(i < len-1 && ch == password.charAt(i+1)) return false;
            if(ch >= 'a' && ch <= 'z') lc = true;
            else if(ch >= 'A' && ch <= 'Z') uc = true;
            else if(ch >= '0' && ch <= '9') d = true;
            else spl = true;
        }
        return lc && uc && d && spl;
    }
}