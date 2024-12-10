class Solution {
    public int maximumLength(String s) {
        Map<String,Integer>map = new HashMap();
        int len = s.length();
        outer:for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            for(int j=i;j<len;j++){
                if(ch != s.charAt(j)){
                    continue outer;
                }
                String str = s.substring(i,j+1);
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