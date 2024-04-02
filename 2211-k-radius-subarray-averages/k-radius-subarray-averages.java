class Solution {
    public int[] getAverages(int[] nums, int k) {
        int len = nums.length;
        int range = 2*k+1;
        int[] ans = new int[len];
        if(range > len)
        {
            Arrays.fill(ans,-1);
            return ans;
        }
        for(int i=0;i<k;i++)
        {
            ans[i] = -1;
            ans[len-i-1] = -1;
        }
        long sum =0;
        for(int i=0;i<range;i++)
        {
            sum += nums[i];
        }
        for(int i=k;i<len-k;i++)
        {
            ans[i] =(int) (sum/range);
            if(i < len-k-1)
            {
                sum += nums[i+k+1];
                sum -= nums[i-k];
            }
        }
        return ans;
    }
}