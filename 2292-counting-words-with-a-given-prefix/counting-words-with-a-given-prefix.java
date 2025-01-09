class Solution {
    public int prefixCount(String[] words, String pref) {
        int countOfPrefix = 0;
        for(String word : words){
            if(word.startsWith(pref)) countOfPrefix++;
        }
        return countOfPrefix;
    }
}