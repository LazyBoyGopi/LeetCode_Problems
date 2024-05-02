class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : ransomNote.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch : magazine.toCharArray())
        {
            if(map.containsKey(ch))
            {
                map.put(ch,map.get(ch)-1);
            }
        }
        for(Integer value : map.values())
        {
            if(value > 0) return false;
        }
        return true;
    }
}