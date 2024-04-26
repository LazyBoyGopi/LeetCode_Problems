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
        else{
            map.put(ch,i);
        }
        
       }
       for(Map.Entry<Character,Integer> entry : map.entrySet())
        {
            if(entry.getValue() != -1) return entry.getValue();
        }
        return -1;

















        // int i = 0;
        // while(i<s.length())
        // {
        //     int count = 0;
        //     char cur = s.charAt(i);
        //     for(int j=0;j<s.length();j++)
        //     {
        //         if(s.charAt(j) == cur) count++;
        //     }
        //     if(count == 1) return i;
        //     i++;
        // }
        // return -1;
    }
}