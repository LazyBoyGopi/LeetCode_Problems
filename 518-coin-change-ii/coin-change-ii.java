class Solution {
    int addCoins(int amount,int[]coins,int idx,int curAmount)
    {
        if(idx == coins.length)
        {
            if(curAmount == amount) return 1;
            return 0;
        }
        int com =0;
        com += addCoins(amount,coins,idx+1,curAmount);
        while(curAmount < amount)
        {
            curAmount += coins[idx];
            if(curAmount <= amount)
            com += addCoins(amount,coins,idx+1,curAmount);
        }
        return com;
    }
    public int change(int amount, int[] coins) {
        // return addCoins(amount,coins,0,0);
        int[]dp = new int[amount+1];
        dp[0] = 1;
        for(int coin : coins)
        {
            for(int i=coin;i<=amount;i++)
            {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}