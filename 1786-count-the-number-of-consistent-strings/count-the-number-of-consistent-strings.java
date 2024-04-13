class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[]freq = new int[26];
        int count = 0;
        for(char ch : allowed.toCharArray())
        {
            freq[ch-'a']++;
        }
        for(String word : words)
        {
            boolean flag = true;
            for(char ch : word.toCharArray())
            {
                if(freq[ch-'a'] == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                {
                    count++;
                }
        }
        return count;
    }
}