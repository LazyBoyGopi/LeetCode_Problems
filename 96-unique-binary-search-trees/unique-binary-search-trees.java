class Solution {
    private int getCombinations(int n , int[]dp)
    {
        if(n <= 1) return 1;
        if(dp[n] != 0) return dp[n];
        for(int i=1;i<=n;i++)
        {
            dp[n] += getCombinations(i-1,dp)*getCombinations(n-i,dp);
        }
        return dp[n];
    }
    public int numTrees(int n) {
        int[]dp = new int[n+1];
        return getCombinations(n,dp);
    }
}