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
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for(int i=0;i<k && i<len;i++){
            sb.append(s.charAt(i));
        }
        set.add(sb.toString());
        for(int i=k;i<len;i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            set.add(sb.toString());
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