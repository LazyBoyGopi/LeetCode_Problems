class Solution {
    private boolean isPossible(int[]nums,int k, int maxSum)
    {
        int sum = 0;
        for(int ele : nums)
        {
            if(sum + ele <= maxSum) sum += ele;
            else{
                sum = ele;
                k--;
            }
        }
        return --k >= 0;
    }
    public int splitArray(int[] nums, int k) {
        int st = 0 , end = 0;
        for(int ele : nums)
        {
            st = Math.max(st,ele);
            end += ele;
        }
        while(st <= end)
        {
            int mid = st+(end-st)/2;
            if(isPossible(nums,k,mid))
            {
                end = mid-1;
            }
            else{
                st = mid+1;
            }
        }
        return st;
    }
}