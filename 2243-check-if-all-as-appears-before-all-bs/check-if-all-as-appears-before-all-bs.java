class Solution {
    public boolean checkString(String s) {
        int firstBIdx = s.indexOf("b");
        if(firstBIdx == -1) return true;
        int aIdx = 0;
        while(aIdx != -1){
            aIdx = s.indexOf("a",aIdx+1);
            if(aIdx > firstBIdx) return false;
        }
        return true;
    }
}