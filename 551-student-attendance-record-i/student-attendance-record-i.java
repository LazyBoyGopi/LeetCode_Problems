class Solution {
    public boolean checkRecord(String s) {
        int abs_count = 0 , late_count = 0;
        for(char ch : s.toCharArray())
        {
            if(ch == 'A') {
                abs_count++;
                late_count = 0;
            }
            else if(ch == 'L') late_count++;
            else if(ch == 'P') late_count = 0;
            if(abs_count > 1) return false;
            if(late_count >= 3) return false;
        }
        return true;
    }
}