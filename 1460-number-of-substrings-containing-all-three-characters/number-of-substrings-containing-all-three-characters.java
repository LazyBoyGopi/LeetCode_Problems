class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0, right = 0, len = s.length(), totSubstrings = 0;
        int[]freq = new int[3];
        while(right < len){
            char ch = s.charAt(right);
            freq[ch-'a']++;

            while(hasAllCharacters(freq)){
                totSubstrings += len-right;
                freq[s.charAt(left++)-'a']--;
            }
            right++;
        }
        return totSubstrings;
    }
    private boolean hasAllCharacters(int[]freq){
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }
}