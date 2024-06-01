class Solution {
    private int rec(int[]nums,int[][]dp,int curIdx,int preIdx){
        if(curIdx == nums.length) return 0;
        if(dp[curIdx][preIdx+1] != -1) return dp[curIdx][preIdx+1];

        int len = rec(nums,dp,curIdx+1,preIdx);
        if(preIdx == -1 || nums[curIdx] > nums[preIdx]){
            len = Math.max(len,1+rec(nums,dp,curIdx+1,curIdx));
        }

        return dp[curIdx][preIdx+1] = len;
    }
    public int lengthOfLIS(int[] nums) {
        int[][]dp = new int[nums.length][nums.length+1];
        for(int[]ar : dp) Arrays.fill(ar,-1);
        return rec(nums,dp,0,-1);
    }
}