class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) return false;
        boolean vowel = false , consonant = false;
        for(char ch : word.toCharArray()){
            if(ch >= '0' && ch <= '9') {
                continue;
            }
            else if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                if(ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U'){
                    vowel = true;
                }
                else consonant = true;
            }
            else return false;
        }
        return vowel && consonant;
    }
}