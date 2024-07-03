class Solution {
    public int minDifference(int[] nums) {
       if(nums.length <= 4) return 0;
       if(nums.length == 5) return 1;
       int len = nums.length;
       Arrays.sort(nums);
       int x1 = nums[len-4]-nums[0];
       int x2 = nums[len-3]-nums[1];
       int x3 = nums[len-2] - nums[2];
       int x4 = nums[len-1] - nums[3];
       return Math.min(x1,Math.min(x2,Math.min(x3,x4)));
    }
}