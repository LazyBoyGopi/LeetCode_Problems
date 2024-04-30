import java.util.*;
class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ele = s.charAt(i);
           if(map.containsKey(ele))
           {
            map.put(ele,-1);
           }
           else map.put(ele,i);
        }
        Collection<Integer>values = map.values();
        for(Integer value : values)
        {
            if(value != -1) return value;
        }
        return -1;
    }
}