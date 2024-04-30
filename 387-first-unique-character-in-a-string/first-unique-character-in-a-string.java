class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ele = s.charAt(i);
            map.put(ele , map.getOrDefault(ele,0)+1);
        }
        for(int i=0;i<s.length();i++)
        {
            if(map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}