class Solution {
    int Z,O,L,H;
    final int MOD = (int)(1e9+7);

    private int getAllCombinations(int l,int[]dp){
        if(l > H) return 0;
        if(dp[l] != -1) return dp[l];
        int add = 0;
        if(l >= L && l <= H) add = 1;
        int add_zero = getAllCombinations(l+O,dp);
        int add_one = getAllCombinations(l+Z,dp);
        return dp[l] = (add_zero + add_one + add)%MOD;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        Z = zero;
        H = high;
        L = low;
        O = one;

        int[]dp = new int[H+1];
        Arrays.fill(dp,-1);

        return getAllCombinations(0,dp);
    }
}