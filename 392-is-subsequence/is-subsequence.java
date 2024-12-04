class Solution {
    public boolean isSubsequence(String s, String t) {
        int l1 = s.length(), l2 = t.length(), p1 = 0 , p2 = 0;
        while(p1 < l1 && p2 < l2){
            if(s.charAt(p1) == t.charAt(p2)) p1++;
            p2++;
        }
        return p1 == l1;
    }
}