class Solution {
    public long countOfSubstrings(String word, int k) {

        long numOfSubstring = 0;
        int left = 0, right = 0, len = word.length(), nextConIdx = len, constantCount = 0;

        int[]nextConsonentIndex = new int[len];
        Map<Character,Integer>vowelCount = new HashMap();

        for(int i=len-1;i>=0;i--){
            nextConsonentIndex[i] = nextConIdx;
            if(!isVowel(word.charAt(i))){
                nextConIdx = i;
            }
        }
        while(right < len){
            char rightCh = word.charAt(right);
            if(isVowel(rightCh)){
                vowelCount.put(rightCh,vowelCount.getOrDefault(rightCh,0)+1);
            }else{
                constantCount++;
            }
            while(constantCount > k){
                char leftCh = word.charAt(left);
                if(isVowel(leftCh)){
                    vowelCount.put(leftCh,vowelCount.get(leftCh)-1);
                    if(vowelCount.get(leftCh) == 0){
                        vowelCount.remove(leftCh);
                    }
                }else{
                    constantCount--;
                }
                left++;
            }
            while(left < len && constantCount == k && vowelCount.size() == 5){
                char ch = word.charAt(left);
                numOfSubstring += nextConsonentIndex[right]-right;
                if(isVowel(ch)){
                    vowelCount.put(ch,vowelCount.get(ch)-1);
                    if(vowelCount.get(ch) == 0){
                        vowelCount.remove(ch);
                    }
                }else{
                    constantCount--;
                }
                left++;
            }
            right++;
        }
        return numOfSubstring;
    }
    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}