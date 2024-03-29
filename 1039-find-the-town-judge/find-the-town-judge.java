class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean [] freq = new boolean[n+1];
        for(int[] ar : trust)
        {
            freq[ar[0]] = true;
        }
        int letJudge = -1;
        for(int i=1;i<n+1;i++)
        {
            if(!freq[i]) letJudge = i;
        }
        Arrays.fill(freq,false);
        for(int[] ar : trust)
        {
            if(ar[1] == letJudge) freq[ar[0]] = true;
        }
        for(int i=1;i<n+1;i++)
        {
            if(i != letJudge && !freq[i]) return -1;
        }
        return letJudge;
    }
}