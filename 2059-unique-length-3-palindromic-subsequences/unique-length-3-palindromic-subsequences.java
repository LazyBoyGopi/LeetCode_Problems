class Solution {
    /*

    private int getUnique(String s,int st,int end){
        Set<Character>set = new HashSet();
        for(int i=st;i<=end;i++){
            set.add(s.charAt(i));
        }
        return set.size();
    }
    
    
    public int countPalindromicSubsequence(String s) {
        int len = s.length();
        int[]preSum = new int[len];
        int uniqueCharacters = 0;
        Set<Character>set = new HashSet();
        for(int i=0;i<len;i++){
            char curCh = s.charAt(i);
            if(!set.contains(curCh)){
                uniqueCharacters++;
                set.add(curCh);
            }
            preSum[i] = uniqueCharacters;
        }
        System.out.println(set);
        System.out.println(Arrays.toString(preSum));

        int[]ansForeachCharacter = new int[26];
        Map<Character,Integer>map = new HashMap();
        for(int i=0;i<len;i++){
            char curCh = s.charAt(i);
            if(map.containsKey(curCh)){
                int firstSee = map.get(curCh);
                if(i-1 > firstSee)
                    {
                        // ansForeachCharacter[curCh-'a'] = getUnique(s,firstSee+1,i-1);

                        ansForeachCharacter[curCh-'a'] = preSum[i]-preSum[firstSee]-1;
                        System.out.println(firstSee+" "+i);
                    }
            }
            else map.put(curCh,i);
        }
        int ans = 0;
        for(int ele : ansForeachCharacter){
            ans += ele;
        }
        return ans;    
    
     */
    private int getCountUniqueCharacters(String s,int st,int end){
        if(st > end) return 0;
        Set<Character>set = new HashSet();
        for(;st<=end;st++) set.add(s.charAt(st));
        return set.size();
    }
    public int countPalindromicSubsequence(String s) {
        int [] spForEachCh = new int[26];
        int [] indexes = new int[26];
        Set<Character>checkedCharacters = new HashSet();
        Arrays.fill(indexes,-1);
        int len = s.length();
        for(int i=0;i<len;i++){
            int curCh = s.charAt(i)-'a';
            if(indexes[(curCh)] == -1){
                indexes[(curCh)] = i;
            }
        }
        for(int i=len-1;i>=0;i--){
            char ch = s.charAt(i);
            int curCh = ch-'a';
            int firstIdx = indexes[curCh];
            if(firstIdx < i && !checkedCharacters.contains(ch)){
                spForEachCh[curCh] = getCountUniqueCharacters(s,firstIdx+1,i-1);
                checkedCharacters.add(ch);
            }
        }
        int ans = 0;
        for(int ele : spForEachCh) ans += ele;
        return ans;
    }
}