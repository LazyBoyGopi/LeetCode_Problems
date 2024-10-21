class Solution {
    int maxCount = 0;
    private void checkAllCombinations(String s, Set<String>set,int idx){
        if(idx >= s.length()){
            maxCount = Math.max(maxCount,set.size());
            return;
        }
        for(int i=idx+1;i<=s.length();i++){
            String curStr = s.substring(idx,i);
           if(!set.contains(curStr)){
                 set.add(curStr);
            checkAllCombinations(s,set,i);
            set.remove(curStr);
           }
        }
    }
    public int maxUniqueSplit(String s) {
        maxCount = 0;
        checkAllCombinations(s,new HashSet(),0);
        return maxCount;
    }
}