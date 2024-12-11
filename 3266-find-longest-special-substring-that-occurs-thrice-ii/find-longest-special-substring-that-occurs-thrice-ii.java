class Solution {
    public int maximumLength(String s) {
        int[][]freqAr = new int[26][3];
        int windowLen = 0, len = s.length();
        char lastCh = '*';
        for(int i=0;i<len;i++){
            char curCh = s.charAt(i);
            int curIdx = curCh-'a';
            windowLen = (curCh == lastCh) ? windowLen+1 : 1;
            int minIdxOfCurCh = getMinIdx(freqAr[curIdx]);
            if(windowLen > freqAr[curIdx][minIdxOfCurCh]){
                freqAr[curIdx][minIdxOfCurCh] = windowLen;
            }
            lastCh = curCh;
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<26;i++){
            int curMinIdx = getMinIdx(freqAr[i]);
            int curMinValue = freqAr[i][curMinIdx];
            ans = Math.max(ans,curMinValue);
        }
        return ans == 0 ? -1 : ans;
    }
    public static int getMinIdx(int[]ar){
        int a = ar[0], b = ar[1], c = ar[2];
        if(a <= b && a <= c) return 0;
        if(b <= c && b <= a) return 1;
        return 2;
    }
}