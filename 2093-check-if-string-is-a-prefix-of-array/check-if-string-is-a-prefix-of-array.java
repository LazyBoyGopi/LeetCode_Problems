class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int curIdx = 0 , idx = 0;
        for(curIdx=0;curIdx<s.length();){
            System.out.println(curIdx);
            if(idx == words.length || curIdx+words[idx].length() > s.length()) return false;
            if(s.substring(curIdx,curIdx+words[idx].length()).equals(words[idx])){
                curIdx += words[idx].length();
                idx++;
            }
            else return false;
        }
        return true;
    }
}