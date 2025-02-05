class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int len = s1.length(), diffChar = 0, idx1 = -1, idx2 = -1;
        for(int i=0;i<len;i++){
            if(s1.charAt(i) != s2.charAt(i)){
                diffChar++;
                if(diffChar == 1) idx1 = i;
                else if(diffChar == 2) idx2 = i;
                else return false;
            }
        }
        if(diffChar == 1) return false;
        char c1 = (idx1 != -1) ? s1.charAt(idx1) : '*', c2 = (idx2 != -1) ? s1.charAt(idx2) : '*', c3 = (idx1 != -1) ? s2.charAt(idx1) : '*', c4 = (idx2 != -1) ? s2.charAt(idx2) : '*';
        return (c1 == c4) && (c2 == c3);
    }
}