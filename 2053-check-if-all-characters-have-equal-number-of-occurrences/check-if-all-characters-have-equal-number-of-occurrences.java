class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character,Integer>map = new HashMap();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int occu = map.get(s.charAt(0));
        for(int value : map.values()){
            if(value != occu) return false;
        }
        return true;
    }
}