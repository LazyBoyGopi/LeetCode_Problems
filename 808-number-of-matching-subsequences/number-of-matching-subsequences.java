class Solution {
    private boolean isSubsequnce(String s1, String s2,Map<Character,Integer>m) {
        Map<Character,Integer>map = new HashMap(m);
        int i1 = 0, i2 = 0, len1 = s1.length(), len2 = s2.length();
        while (i1 < len1 && i2 < len2) {
            if (s1.charAt(i1) == s2.charAt(i2)) {
                char ch = s2.charAt(i2);
                i1++;
                i2++;
                map.put(ch,map.get(ch)-1);
                if(map.get(ch) == 0) map.remove(ch);
            }
            if (i2 < len2) {
                while (i1 < len1 && s1.charAt(i1) != s2.charAt(i2)) {
                    char ch = s2.charAt(i2);
                    i1++;
                    if(!map.containsKey(ch)) {
                        return false;
                    }
                }
            }
        }
        return i2 >= len2;
    }

    public int numMatchingSubseq(String s, String[] words) {
        int count = 0, len= s.length();
        Map<Character,Integer>map = new HashMap();
        Set<String>repeated = new HashSet();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (repeated.contains(word) || isSubsequnce(s, word,map))
                {
                    repeated.add(word);
                    count++;
                }
        }
        return count;
    }
}