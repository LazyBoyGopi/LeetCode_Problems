class Solution {
    public int maximumJumps(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            int max = -1;
            for (int j = i + 1; j < len; j++) {
                if (Math.abs(nums[j] - nums[i]) <= target) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max != -1 ? max+1 : -1;
        }
        return dp[0];
    }
}