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
        while(low < nums.length && high < nums.length)
        {
            while(low < nums.length && countOfMaxEle >= k)
            {
                if(countOfMaxEle >= k) {
                    subarrayCount += nums.length-high+1;
               }
               if(nums[low++] == maxEle) countOfMaxEle--;
            }
            if(nums[high++] == maxEle) countOfMaxEle++;
        }
        System.out.println(subarrayCount);
        while(low < nums.length && countOfMaxEle >= k)
            {
                if(countOfMaxEle >= k) {
                    subarrayCount += nums.length-high+1;
               }
               if(nums[low++] == maxEle) countOfMaxEle--;
            }
        return subarrayCount;
    }
}