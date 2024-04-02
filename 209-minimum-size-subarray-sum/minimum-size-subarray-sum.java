class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0 , sum = 0 , len = nums.length+1;
        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
            while(sum >= target)
            {
                len = Math.min(len,i-low+1);
                sum -= nums[low++];
            }
        }
        if(len > nums.length) return 0;
        return len;
    }
}