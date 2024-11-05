class Solution {
    public int minChanges(String s) {
        int changesCount = 0, len = s.length();
        for(int i=0;i<len;i+=2){
            if(s.charAt(i) != s.charAt(i+1)) changesCount++;
        }
        return changesCount;
    }
}