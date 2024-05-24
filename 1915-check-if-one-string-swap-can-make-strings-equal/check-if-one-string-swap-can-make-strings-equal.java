class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        int[]freq = new int[26];
        for(int i=0;i<s2.length();i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            freq[ch1-'a']++;
            freq[ch2-'a']--;
            if(ch1 != ch2) count++;
            if(count > 2) return false;
        }
        int count2 = 0;
        for(int ele : freq) if(ele != 0) return false;
        if(count == 2 || count == 0) return true;
        return false;
    }
}