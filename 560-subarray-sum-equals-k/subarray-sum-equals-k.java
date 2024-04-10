class Solution {
    public int subarraySum(int[] nums, int k) {
        int preSum [] = new int[nums.length];
        int count = 0;
        preSum[0] = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            preSum[i] = preSum[i-1]+nums[i];
        }
        for(int i=0;i<nums.length;i++)
        {
            if(preSum[i] == k) count++;
            int idx = i-1;
            while(idx >=0)
            {
                if(preSum[i]-preSum[idx] == k) count++;
                // else if(preSum[i] - preSum[idx] > k) break;
                idx--;

            }
        }
        return count;
    }
}