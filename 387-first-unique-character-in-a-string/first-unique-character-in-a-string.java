class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(map.containsKey(ch))
            {
                map.put(ch,-1);
            }
            else map.put(ch,i);
        }
        char ch = ' ';
        System.out.println(map);
        for(Map.Entry<Character,Integer> entry : map.entrySet())
        {
            if(entry.getValue() != -1) {
                ch = entry.getKey();
                break;
            }
        }
        if(ch == ' ') return -1;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == ch) return i;
        }
        return -1;
    }
}