class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int lenOfS1 = s1.length();
        int curS2Idx = 0, lenOfS2 = s2.length();

        if(lenOfS2 < lenOfS1) return false;

        int[]freqOfS1 = new int[26];
        int[]windowCharacters = new int[26];
        
        for(int i=0;i<lenOfS1;i++){
            freqOfS1[s1.charAt(i)-'a']++;
        }

        for(int i=0;i<lenOfS1;i++){
            windowCharacters[s2.charAt(i)-'a']++;
        }
        do{
            int i=0;
            for(;i<26;i++){
                if(freqOfS1[i] != windowCharacters[i]){
                    i++;
                    break;
                }
            }
            if(i==26) return true;
            windowCharacters[s2.charAt(curS2Idx)-'a']--;
            if(curS2Idx+lenOfS1 < lenOfS2){
                windowCharacters[s2.charAt(curS2Idx+lenOfS1)-'a']++;
            }else{
                return false;
            }
            curS2Idx++;
        }
        while(curS2Idx+lenOfS1 <= lenOfS2);
        return false;
    }
}