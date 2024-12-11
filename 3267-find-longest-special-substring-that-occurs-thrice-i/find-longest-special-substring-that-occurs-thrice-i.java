class Solution {
    public int maximumLength(String s) {
        int len = s.length();
        int[][]freqAr = new int[26][3];
        int windowLen = 0;
        char lastCh = '*';
        for(int i=0;i<len;i++){
            char curCh = s.charAt(i);
            int curIdx = curCh-'a';
            windowLen = (lastCh == curCh) ? windowLen+1 : 1;
            int minIdxOfCurCh = getMinIdx(freqAr[curIdx]);
            // System.out.println(minIdxOfCurCh);
            if(windowLen > freqAr[curIdx][minIdxOfCurCh]){
                freqAr[curIdx][minIdxOfCurCh] = windowLen;
            }
            lastCh = curCh;
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<26;i++){
            int curMin = freqAr[i][getMinIdx(freqAr[i])];
            ans = Math.max(ans,curMin);
        }
        // System.out.println(Arrays.deepToString(freqAr));
        return ans == 0 ? -1 : ans;
    }
    private int getMinIdx(int[]ar){
        int a = ar[0],b = ar[1],c = ar[2];
        if(a <= b && a <= c) return 0;
        if(b <= a && b <= c) return 1;
        return 2;
    }
}