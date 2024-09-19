class Solution {
    public boolean isAcronym(List<String> words, String s) {
        if(words.size() != s.length()) return false;
        int len = s.length();
        for(int i=0;i<len;i++){
            if(s.charAt(i) != words.get(i).charAt(0)) return false;
        }
        return true;
    }
}