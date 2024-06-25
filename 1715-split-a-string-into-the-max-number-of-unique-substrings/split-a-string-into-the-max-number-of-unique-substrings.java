class Solution {
    private int getAns(String str,Set<String>set ,int idx){
        if(idx == str.length()){
            return set.size();
        }
        int max = 0;
        for(int right = idx+1;right <= str.length() ;right++){
            String curStr = str.substring(idx,right);
            if(!set.contains(curStr)){
                set.add(curStr);
                max = Math.max(max,getAns(str,set,right));
                set.remove(curStr);
            }
        }
        return max;
    }
    public int maxUniqueSplit(String s) {
       /* Set<String>str = new HashSet<>();
        Set<String>str2 = new HashSet<>();
        int left = 0 , right = 1 , len = s.length();
        while(right < len){
            String curStr = s.substring(left,right);
            if(!str.contains(curStr)){
                str.add(curStr);
                left = right;
            }
            right++;
        }
        String curStr = s.substring(left,right);
        if(!str.contains(curStr)) str.add(curStr);
        return str.size(); */
        return getAns(s,new HashSet<>(),0);
    }
}