class Solution {
    private boolean checkAllCombination(String s,StringBuilder sb,int idx,int k){
        if(idx > k) return true;
        else if(idx == k){
            return s.contains(sb.toString());
        }
        if(!s.contains(sb.toString())) return false;
        sb.setCharAt(idx,'1');
        if(!checkAllCombination(s,sb,idx+1,k)) return false;
        sb.setCharAt(idx,'0');
        return checkAllCombination(s,sb,idx+1,k);
    }
    private Set<String> getAllSubStrOfLenK(String s,int k){
        Set<String>set = new HashSet();
        int len = s.length();
        for(int i=0;i+k<=len;i++){
            set.add(s.substring(i,i+k));
        }
        return set;
    }
    public boolean hasAllCodes(String s, int k) {
        /*
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<k;i++){
            sb.append('0');
        }
        return checkAllCombination(s,sb,0,k); 
        */
        return getAllSubStrOfLenK(s,k).size() == Math.pow(2,k);
    }
}