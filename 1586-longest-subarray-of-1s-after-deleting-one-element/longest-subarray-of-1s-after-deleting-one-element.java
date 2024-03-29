class Solution {
    public int longestSubarray(int[] nums) {
        int low = 0 , high = 0;
        int countOfZeroes = 0 , maxLen = 0;
        while(high < nums.length)
        {
            if(nums[high] == 0) countOfZeroes++;
            if(countOfZeroes > 1 || high == nums.length-1) {
                if(countOfZeroes == 2)
                maxLen = Math.max(maxLen,high-low-1);
                else
                maxLen = Math.max(maxLen,high-low);
            }
            while(countOfZeroes > 1)
            {
                if(nums[low++] == 0) countOfZeroes--;
            }
            high++;
        }
        return maxLen;
    }
}