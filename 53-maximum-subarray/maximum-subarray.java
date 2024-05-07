class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0 , max = Integer.MIN_VALUE;
        int high = 0 , low = 0;
        for(int i=0;i<nums.length;i++)
        {
            int ele = nums[i];
            sum += ele;
            if(sum > max)
            {
                high = i;
                max = sum;
            }
            if(sum < 0) {
                sum = 0;
                low = i;
            }
        }
        return max;
    }
}