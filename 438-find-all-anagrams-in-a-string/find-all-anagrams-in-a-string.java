class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList();

        int pLen = p.length(), sLen = s.length();
        if (pLen > sLen)
            return list;

        int[] freqOfP = new int[26];
        for (int i = 0; i < pLen; i++) {
            freqOfP[p.charAt(i) - 'a']++;
            freqOfP[s.charAt(i)-'a']--;
        }

        int diffCount = 0;
        for (int i=0; i < 26; i++) {
            if (freqOfP[i] != 0)
                diffCount++;
        }
        if (diffCount == 0)
            list.add(0);

        int curSIdx = 0;
        while (curSIdx + pLen < sLen){
            // System.out.println(Arrays.toString(freqOfP));
            // Process the character coming into the window
            if (freqOfP[s.charAt(curSIdx + pLen) - 'a'] == 0) diffCount++;
            freqOfP[s.charAt(curSIdx + pLen) - 'a']--;
            if (freqOfP[s.charAt(curSIdx + pLen) - 'a'] == 0) diffCount--;

            // Process the character going out of the window
            if (freqOfP[s.charAt(curSIdx) - 'a'] == 0) diffCount++;
            freqOfP[s.charAt(curSIdx) - 'a']++;
            if (freqOfP[s.charAt(curSIdx) - 'a'] == 0) diffCount--;

            // If diffCount is 0, we found another anagram
            if (diffCount == 0)
                list.add(curSIdx + 1);

            curSIdx++;
        }

        return list;
    }
}