class Solution {
    public boolean rotateString(String s, String goal) {
       /* int l1 = s.length() , l2 = goal.length();
        if(l1 != l2) return false;
        int i=-1;
        char firstCh = goal.charAt(0);
        do{
            i = s.indexOf(firstCh,i+1);
            if(i == -1) return false;
            String s1 = s.substring(0,i);
            String s2 = s.substring(i);
            String g1 = goal.substring(0,s2.length());
            String g2 = goal.substring(s2.length());
            if(s2.equals(g1) && s1.equals(g2)) return true;
        }
        while(i != -1);
        return false; */
        if(s.length() != goal.length()) return false;
        return (s+s).contains(goal);
    }
}