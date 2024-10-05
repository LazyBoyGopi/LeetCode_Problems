class Solution {
    public boolean isAnagram(String s, String t) {
        int sl = s.length(), tl = t.length();
        if(sl != tl) return false;
        int []freq = new int[26];
        for(int i=0;i<sl;i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(freq[i] != 0) return false;
        }
        return true;
    }
}