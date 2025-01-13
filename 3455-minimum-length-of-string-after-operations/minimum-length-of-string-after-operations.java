class Solution {
    public int minimumLength(String s) {
        int len = s.length();
        Map<Character,Integer>map = new HashMap();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int newLen = 0;
        for(int value : map.values()){
            if(value > 2){
                if((value & 1) == 1) newLen += 1;
                else newLen += 2;
            }else newLen += value;
        }
        return newLen;
    }
}