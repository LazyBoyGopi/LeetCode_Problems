class Solution {
    private int findMax(int[]nums)
    {
        int max = Integer.MIN_VALUE;
        for(int ele : nums) max = Math.max(max,ele);
        return max;
    }
    private boolean isPossible(int[]nums,int mid,int threshold)
    {
        int sum = 0;
        for(int ele : nums)
        {
            sum += Math.ceil(ele*1.0/mid);
            if(threshold < sum) return false;
        }
        return threshold >= sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int st = 1 , end = findMax(nums);
        while(st <= end)
        {
            int mid = st+(end-st)/2;
            if(isPossible(nums,mid,threshold))
            {
                end = mid-1;
            }
            else st = mid+1;
        }
        return st;
    }
}