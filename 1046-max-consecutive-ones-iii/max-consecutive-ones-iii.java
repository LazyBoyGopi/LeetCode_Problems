class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, maxLen = 0, count = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                count++;
            }
            while (count > k && left <= right) {
                maxLen = Math.max(maxLen, right - left);
                if (nums[left++] == 0)
                    count--;
            }
            right++;
        }
        return Math.max(maxLen, right - left);
    }
}