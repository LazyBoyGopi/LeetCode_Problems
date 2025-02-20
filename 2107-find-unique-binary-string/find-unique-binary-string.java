class Solution {
    private String dfs(Set<String>set,int n,StringBuilder cur){
        if(cur.length() == n){
            if(set.contains(cur.toString())){
                return "";
            }
            return cur.toString();
        }
        cur.append('0');
        String s = dfs(set,n,cur);
        if(s.length() != 0){
            return s;
        }
        cur.setLength(cur.length()-1);
        cur.append('1');
        s = dfs(set,n,cur);
        if(s.length() != 0){
            return s;
        }
        cur.setLength(cur.length()-1);
        return "";
    }
    public String findDifferentBinaryString(String[] nums) {
        Set<String>set = new HashSet();
        for(String s : nums){
            set.add(s);
        }
        return dfs(set,nums.length,new StringBuilder());
    }
}