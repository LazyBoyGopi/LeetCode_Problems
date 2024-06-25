class Solution {
    private int getAns(String s,Set<String>set,int idx){
        if(idx == s.length()) return set.size();
        int max = 0;
        for(int right = idx+1;right <= s.length();right++){
            String cur = s.substring(idx,right);
            if(!set.contains(cur)){
                set.add(cur);
                max = Math.max(getAns(s,set,right),max);
                set.remove(cur);
            }
        }
        return max;
    }
    public int maxUniqueSplit(String s) {
        return getAns(s,new HashSet<>(),0);
    }
}