class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length%2 == 0 ? (nums[nums.length/2]+nums[(nums.length/2)-1])/2 : nums[nums.length/2];
        int total = 0;
        for(int ele : nums)
        {
            total += Math.abs(ele-mid);
        }
        return total;
    }
}