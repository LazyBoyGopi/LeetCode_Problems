class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 1;
        for(int i=0;i<nums.length;i++) max = Math.max(max,nums[i]);

        int left = 0 , right = 0 , len = nums.length ;
        long subarrayCount = 0 ,highEle = 0;
        while(right < len){
            if(nums[right] == max) highEle++;
            while(highEle >= k){
                subarrayCount += len-right;
                if(nums[left++] == max) highEle--; 
            }
            right++;
        }
        return subarrayCount;
    }
}