class Solution {
    private boolean isVowel(char ch)
    {
        switch(ch)
            {
                case 'a' : 
                case 'e' :
                case 'i' :
                case 'o' :
                case 'u' : return true;
            }
            return false;
    }
    public int maxVowels(String s, int k) {
        int low = 0  , high = 0;
        int vowelsCount = 0 , maxLen = 0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        while(high < s.length()){
            if(vowels.contains(s.charAt(high))){
                vowelsCount++;
            }
            if(high-low+1 == k)
            {
                if(vowelsCount == k) return k;
                maxLen = Math.max(vowelsCount,maxLen);
                if(vowels.contains(s.charAt(low))) vowelsCount--;
                low++;
            }
            high++;
        }
        return maxLen;
    }
}