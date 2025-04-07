class Solution {
    private boolean checkPossibilities(int[] nums, int idx, int target, int[][] dp) {
        if (target == 0) return true;
        if (idx == 0) return nums[0] == target;

        if (dp[idx][target] != 0) return dp[idx][target] == 1;

        boolean notPick = checkPossibilities(nums, idx - 1, target, dp);
        boolean pick = false;
        if (nums[idx] <= target)
            pick = checkPossibilities(nums, idx - 1, target - nums[idx], dp);

        dp[idx][target] = (pick || notPick) ? 1 : 2;
        return dp[idx][target] == 1;
    }

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int ele : nums) totalSum += ele;

        if ((totalSum & 1) == 1) return false;

        int target = totalSum / 2;
        int[][] dp = new int[nums.length][target + 1];

        return checkPossibilities(nums, nums.length - 1, target, dp);
    }
}
