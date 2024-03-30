class Solution {
    public int countCharacters(String[] words, String chars) {
        int len = 0;
        int[] freq = new int[26];
        for(char ch : chars.toCharArray())
        {
            freq[ch-97]++;
        }
        for(String word : words)
        {
            int[] ar = Arrays.copyOf(freq,freq.length);
            boolean isPossible = true;
            for(char ch : word.toCharArray())
            {
                if(ar[ch-97] <= 0) {
                    isPossible = false;
                    break;
                }
                else ar[ch - 97]--;
            }
            if(isPossible) len += word.length();
        }
        return len;
    }
}