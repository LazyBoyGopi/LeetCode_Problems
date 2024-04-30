class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int ele : nums) if(ele < min) min = ele;
        int count = 0;
        for(int i= nums.length-1;i>=0;i--)
        {
            count += nums[i] - min;
        }
        return count;
    }
}