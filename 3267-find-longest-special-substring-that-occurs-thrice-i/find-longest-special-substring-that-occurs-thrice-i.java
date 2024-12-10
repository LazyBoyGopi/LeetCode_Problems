class Solution {
    private boolean isPossible(String str){
       char ch = str.charAt(0);
       for(int i=1;i<str.length();i++){
        if(ch != str.charAt(i)) return false;
       }
       return true;
    }
    public int maximumLength(String s) {
        Map<String,Integer>map = new HashMap();
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String str = s.substring(i,j);
                if(isPossible(str))
                    map.put(str,map.getOrDefault(str,0)+1);
            }
        }
        int maxLen = -1;
        for(Map.Entry<String,Integer>entry : map.entrySet()){
            if(entry.getValue() > 2){
                maxLen = Math.max(maxLen,entry.getKey().length());
            }
        }
        return maxLen;
    }
}