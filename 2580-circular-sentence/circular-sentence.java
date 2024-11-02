class Solution {
    public boolean isCircularSentence(String sentence) {
        int last = 0, cur = 1, len = sentence.length();
        if(sentence.charAt(0) != sentence.charAt(len-1)) return false;
        while(cur < len){
            if(sentence.charAt(cur) != ' ') {
                last++;
                cur++;
            }else{
                cur++;
                if(cur >= len) return true;
                if(sentence.charAt(last) != sentence.charAt(cur)) return false;
                last = cur;
                cur++;
            }
        }
        return true;
    }
}