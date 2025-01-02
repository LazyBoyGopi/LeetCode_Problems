class Solution {
    Set<Character>set = new HashSet();
    /*
     * int qLen = queries.length, wLen = words.length;
     * int[]ans = new int[qLen];
     * for(int i=0;i<qLen;i++){
     * int end = queries[i][1], st = queries[i][0];
     * int count = 0;
     * for(int j=st;j<=end;j++){
     * String word = words[j];
     * char f = word.charAt(0);
     * char l = word.charAt(word.length()-1);
     * boolean first = false,last = false;
     * if(f == 'a' || f == 'e' || f == 'i' || f == 'o' || f == 'u') first = true;
     * if(l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u') last = true;
     * 
     * if(first & last) count++;
     * }
     * ans[i] = count;
     * }
     * return ans;
     */
    public int[] vowelStrings(String[] words, int[][] queries) {

        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');



        int qLen = queries.length, wLen = words.length;
        int count = 0;
        int[] preSum = new int[wLen];
        int[] ans = new int[qLen];

        for (int i = 0; i < wLen; i++) {

            String word = words[i];
            char f = word.charAt(0);
            char l = word.charAt(word.length() - 1);
            boolean first = false, last = false;

            if (set.contains(f))
                first = true;
            if (set.contains(l))
                last = true;

            if (first & last)
                count++;
            
            preSum[i] = count;
        }
        
        for(int i=0;i<qLen;i++){
            int st = queries[i][0], end = queries[i][1];
            int curValue = preSum[end] - (st > 0 ? preSum[st-1] : 0); 
            ans[i] = curValue;
        }

        return ans;
    }
}