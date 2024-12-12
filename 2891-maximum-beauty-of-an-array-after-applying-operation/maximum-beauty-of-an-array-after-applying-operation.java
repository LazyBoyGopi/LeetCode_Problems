class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, len = nums.length,max = 0, range = 2*k;
         
        for(int r = 0;r < len ; r++){
            while(nums[r]-nums[l] > range) l++;
            max = Math.max(max,r-l+1);
        }   
        return max;
    }
}