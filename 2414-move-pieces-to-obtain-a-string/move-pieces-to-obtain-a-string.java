class Solution {
    private int findNext(char[]ar,int st,char ch){
        for(;st<ar.length;st++){
            char c = ar[st];
            if(c == 'R') return -1;
            if(c == ch) return st;
        }
        return -1;
    }
    private void swap(char[]ar,int i,int j){
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
    private int findPrevious(char[]ar,int st,char ch){
        for(;st>=0;st--){
            char c = ar[st];
            if(c == 'L') return -1;
            if(c == ch) return st;
        }
        return -1;
    }
    public boolean canChange(String start, String target) {
        char[]s = start.toCharArray();
        char[]t = target.toCharArray();
        for(int i=0;i<s.length;i++){
            char cs = s[i], ct = t[i];
            if(cs == ct) continue;
            if(ct == 'L'){
                int nextL = findNext(s,i,'L');
                if(nextL != -1) swap(s,i,nextL);
            }
        }
        for(int i=s.length-1;i>=0;i--){
            char cs = s[i], ct = t[i];
            if(cs == ct || cs == 'L') continue;
            if(ct == 'R'){
                int previousR = findPrevious(s,i,'R');
                if(previousR != -1) swap(s,i,previousR);
            }
        }
        
        return Arrays.equals(s,t);
    }
}