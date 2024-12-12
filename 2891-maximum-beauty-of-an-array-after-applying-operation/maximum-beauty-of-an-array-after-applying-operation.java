class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = 0, len = nums.length;
        int max = 0, range = 2*k;
        for(;r < len ; r++){
            while(nums[r]-nums[l] > range) l++;
            max = Math.max(max,r-l+1);
        }   
        return max;
    }
}