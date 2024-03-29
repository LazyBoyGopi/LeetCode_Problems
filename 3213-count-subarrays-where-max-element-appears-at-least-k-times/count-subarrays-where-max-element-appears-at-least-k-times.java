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
        while(high < nums.length)
        {
            if(nums[high] == maxEle) countOfMaxEle++;
            while(countOfMaxEle >= k && low <= high)
            {
                subarrayCount += nums.length-high;
               if(nums[low++] == maxEle) countOfMaxEle--;
            }
            high++;
        }
        return subarrayCount;
    }
}