class Solution {
    public boolean canConstruct(String s, int k) {
        int len = s.length();
        if(k > len) return false;
        if(k == len) return true;
        Map<Character,Integer>map = new HashMap();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            int curCountOfCharacter = map.getOrDefault(ch,0);
            map.put(ch,curCountOfCharacter+1);
        }
        int countOfOdd = 0;
        for(int value : map.values()) if(value % 2== 1) countOfOdd++;
        return countOfOdd > k ? false : true;
    }
}