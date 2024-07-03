class Solution {
    public int minDifference(int[] nums) {
       if(nums.length <= 4) return 0;
       int len = nums.length;
       Arrays.sort(nums);
       int min = nums[0];
       int max = nums[len-3-1];
       int min1 = max-min;
       min = nums[3];
       max = nums[len-1];
       int min2 = max-min;
       int ans = Math.min(min1,min2);
       ans = Math.min(ans,nums[len-2]-nums[2]);
       ans = Math.min(ans,nums[len-3]-nums[1]);
       return ans;
    }
}