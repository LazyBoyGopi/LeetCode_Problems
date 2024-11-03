class Solution {
    public int partitionString(String s) {
        Set<Character>set = new HashSet();
        int count = 0, len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                count++;
                set.clear();
            }
            set.add(ch);
        }
        return count+1;
    }
}