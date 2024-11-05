class Solution {
    public boolean checkOnesSegment(String s) {
        int len = s.length(), count = 0;
        for(int i=0;i<len-1;i++){
            char first = s.charAt(i);
            char next = s.charAt(i+1);
            if((first == '1' && next == '0') || (first == '0' && next == '1')) {
                count++;
                if(count > 1) return false;
            }
        }
        return true;
    }
}