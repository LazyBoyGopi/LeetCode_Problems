class Solution {
    public int maximumJumps(int[] nums, int target) {
        int len = nums.length, stPos = -1;
        int[] dp = new int[len];
        dp[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            int max = -1, idx = -1;
            for (int j = i + 1; j < len; j++) {
                int t = nums[j] - nums[i];
                if (dp[j] != -1 && -target <= t && t <= target) {
                    idx = j;
                    max = Math.max(max, dp[j]);
                }
            }
            if (idx != -1) {
                stPos = i;
                
            }
            dp[i] = idx != -1 ? max+1 : -1;
        }
        return stPos == 0 ? dp[0] : -1;
    }
}