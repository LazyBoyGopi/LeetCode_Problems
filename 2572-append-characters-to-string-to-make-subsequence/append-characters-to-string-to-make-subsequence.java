class Solution {
    public int appendCharacters(String s, String t) {
        int last = -1;
        for(int i=0;i<t.length();i++){
            int idx = s.indexOf(t.charAt(i),last+1);
            if(idx == -1){
                return t.length()-i;
            }
            last = idx;
        }
        return 0;
    }
}