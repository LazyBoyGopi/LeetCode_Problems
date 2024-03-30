class Solution {
    public int countCharacters(String[] words, String chars) {
        int len = 0;
        int[] freq = new int[26];
        for(int i=0;i<chars.length();i++)
        {
            freq[chars.charAt(i)-97]++;
        }
        for(String word : words)
        {
            int[] ar =new int[26];
            boolean isPossible = true;
            for(int i=0;i<word.length();i++)
            {
                int idx = word.charAt(i)-97;
                ar[idx]++;
                if(ar[idx] > freq[idx]) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) len += word.length();
        }
        return len;
    }
}