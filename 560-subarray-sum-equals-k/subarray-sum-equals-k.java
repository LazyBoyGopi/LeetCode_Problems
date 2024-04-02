class Solution {
    public int subarraySum(int[] nums, int k) {
        int low = 0, sum = 0, count = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum = 0;
            for(int j=i;j<nums.length;j++)
            {
                sum += nums[j];
                if(sum == k) count++;
            }
        }
        return count;
        // for (int i = 0; i < nums.length; i++) {
        //     sum += nums[i];
        //     if (sum == k)
        //         count++;
        //     if (sum > k) {
        //         while (sum > k) {
        //             sum -= nums[low];
        //             if (sum == k && i - low > 0)
        //                 count++;
        //             low++;
        //         }
        //     }
        //     else if(k > sum){
        //         while (sum > k) {
        //             sum -= nums[low];
        //             if (sum == k && i - low > 0)
        //                 count++;
        //             low++;
        //         }
        //     }
        // }
        // return count;
    }
}