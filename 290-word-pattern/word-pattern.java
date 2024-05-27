class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String,String> map = new HashMap<>();
        String []ar = s.split(" ");
        if(ar.length != pattern.length()) return false;
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch+"") && !map.get(ch+"").equals(ar[i])){
                return false;
            }
            else map.put(ch+"",ar[i]);
            if(map.containsKey(ar[i]+"P") && !map.get(ar[i]+"P").equals(ch+"")){
                return false;
            }
            else map.put(ar[i]+"P",ch+"");
        }
        return true;
    }
}