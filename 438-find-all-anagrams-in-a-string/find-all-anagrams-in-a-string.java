class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>list = new LinkedList();

        int pLen = p.length(), sLen = s.length();
        if(pLen > sLen) return list;

        int[]freqOfP = new int[26];
        for(int i=0;i<pLen;i++){
            freqOfP[p.charAt(i)-'a']++;
        }

        int[]freqOfWindow = new int[26];
        for(int i=0;i<pLen;i++){
            freqOfWindow[s.charAt(i)-'a']++;
        }
        int curSIdx = 0;

        do{
            int i=0;
            for(;i<26;i++){
                if(freqOfWindow[i] != freqOfP[i]) break;
            }
            if(i == 26) list.add(curSIdx);
            freqOfWindow[s.charAt(curSIdx)-'a']--;
            if(curSIdx+pLen < sLen){
                freqOfWindow[s.charAt(curSIdx+pLen)-'a']++;
            }
            curSIdx++;
        }while(curSIdx+pLen <= sLen);

        return list;
    }
}