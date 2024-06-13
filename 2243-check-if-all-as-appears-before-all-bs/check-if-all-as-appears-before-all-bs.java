class Solution {
    public boolean checkString(String s) {
        int firstBIdx = s.indexOf("b") , len = s.length();
        if(firstBIdx == -1) return true;

        for(int i=0;i<len;i++){
            if(s.charAt(i) == 'a' && i > firstBIdx) return false;
        }
        return true;
    }
}