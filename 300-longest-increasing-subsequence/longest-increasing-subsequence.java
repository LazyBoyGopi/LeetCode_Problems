class Solution{
    private int fun(int cur_idx,int pre_idx,int []nums,int[][]dp){
        if(cur_idx == nums.length) return 0;

        if(dp[cur_idx][pre_idx+1] != -1) return dp[cur_idx][pre_idx+1];

        int len = 0+fun(cur_idx+1,pre_idx,nums,dp);
        if(pre_idx == -1 || nums[pre_idx] < nums[cur_idx]){
            len = Math.max(len,1+fun(cur_idx+1,cur_idx,nums,dp));
        }

        return dp[cur_idx][pre_idx+1] =len;
    }
    public int lengthOfLIS(int[] nums) {
        int[][]dp = new int[nums.length][nums.length+1];
        for(int[] ar : dp) Arrays.fill(ar,-1);
        return fun(0,-1,nums,dp);
    }
}


/*class Solution {
    int max = 0;

    private void recu(int[] nums, int idx, int last, int len) {
        if (idx == nums.length) {
            max = Math.max(max, len);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (len == 0) {
                recu(nums, i + 1, nums[i], 1);
            } else {
                if (nums[i] > last) {
                    recu(nums, i + 1, nums[i], len + 1);
                } else
                    recu(nums, i + 1, last, len);
            }
        }
    }

    public int lengthOfLIS(int[] nums) {
        max = 1;
        recu(nums, 0, 0, 0);
        return max;
    }
} */