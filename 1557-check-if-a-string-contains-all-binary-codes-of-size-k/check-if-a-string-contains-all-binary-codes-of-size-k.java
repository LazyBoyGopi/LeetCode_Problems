class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String>set = new HashSet();
        int len = s.length();
        for(int i=0;i+k<=len;i++){
            set.add(s.substring(i,i+k));
        }
        return set.size() == Math.pow(2,k);
    }
}