class Solution {
    private int findMax(int[] nums) {
        int max = nums[0];
        for (int ele : nums) max = Math.max(max, ele);
        return max;
    }

    private boolean isPossible(int maxBalls, int[] nums, int maxOperations) {
        int operationsCount = 0;
        for (int ele : nums) {
            int operations = (ele - 1) / maxBalls; // Integer math avoids rounding issues
            operationsCount += operations;
            if (operationsCount > maxOperations) return false;
        }
        return true;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        if (nums == null || nums.length == 0) return 0; // Handle edge case

        int st = 1, end = findMax(nums);
        while (st <= end) {
            int mid = st + (end - st) / 2; // Avoid integer overflow
            if (isPossible(mid, nums, maxOperations)) {
                end = mid - 1; // Try for a smaller size
            } else {
                st = mid + 1; // Increase the size
            }
        }
        return st; // Final answer
    }
}
