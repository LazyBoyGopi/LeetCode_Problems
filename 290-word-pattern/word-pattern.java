class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        Map<String,Character> reverseMap = new HashMap<>();
        String[]ar = s.split(" ");
        if(ar.length != pattern.length()) return false;
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            String str = ar[i];
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(str)) return false;
            }
            else{
                if(reverseMap.containsKey(str)) return false;
                map.put(ch,str);
                reverseMap.put(str,ch);
            }
        }
        return true;
    }
}