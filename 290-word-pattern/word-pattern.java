class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        String []ar = s.split(" ");
        if(ar.length != pattern.length()) return false;
        for(int i=0;i<pattern.length();i++)
        {   
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(ar[i])) return false;
            }
            else map.put(ch,ar[i]);
        }
        Map<String,Character> map1 = new HashMap<>();
        for(int i = 0;i<ar.length;i++)
        {
            if(map1.containsKey(ar[i]))
            {
                if(map1.get(ar[i]) != pattern.charAt(i)) return false;
            }
            else{
                map1.put(ar[i],pattern.charAt(i));
            }
        }
        return true;
    }
}