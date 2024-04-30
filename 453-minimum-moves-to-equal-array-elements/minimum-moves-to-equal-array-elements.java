class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i= nums.length-1;i>=0;i--)
        {
            count += (nums[i]+count) - (nums[0]+count);
        }
        return count;
    }
}