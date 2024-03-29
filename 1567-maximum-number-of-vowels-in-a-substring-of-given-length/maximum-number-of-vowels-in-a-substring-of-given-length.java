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
        while(high < s.length() && low <s.length()){
            if(isVowel(s.charAt(high))){
                vowelsCount++;
            }
            if(high-low+1 == k)
            {
                if(vowelsCount == k) return k;
                maxLen = Math.max(vowelsCount,maxLen);
                if(isVowel(s.charAt(low))) vowelsCount--;
                low++;
            }
            high++;
        }
        return maxLen;
    }
}