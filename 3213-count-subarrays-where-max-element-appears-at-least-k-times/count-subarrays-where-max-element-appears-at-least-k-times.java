class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxEle = 1;
        for(int ele : nums){
            if(ele > maxEle){
                 maxEle = ele;
            }
        }
        long subarrayCount = 0;
        int countOfMaxEle = 0;
        int low = 0 , high = 0;
        while(high < nums.length && low < nums.length)
        {
            while(countOfMaxEle >= k && low < nums.length)
            {
                subarrayCount += nums.length-high+1;
               if(nums[low++] == maxEle) countOfMaxEle--;
            }
            if(nums[high++] == maxEle) countOfMaxEle++;
        }
        while(low < nums.length && countOfMaxEle >= k)
            {
                subarrayCount += nums.length-high+1;
               if(nums[low++] == maxEle) countOfMaxEle--;
            }
        return subarrayCount;
    }
}