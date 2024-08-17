class Solution {
    private int getMax(int []nums){
        int max = Integer.MIN_VALUE;
        for(int ele : nums) max = Math.max(max,ele);
        return max;
    }
    public int maxSubArray(int[] nums) {
        int sum = 0 , max = getMax(nums);
        int idx = 0 , len = nums.length;
        while(idx < len){
            while(idx < len && sum+nums[idx] >= 0){
                sum += nums[idx++];
                max = Math.max(max,sum);
            }
            sum = 0;
            idx++;
        }
        return max;
    }
}