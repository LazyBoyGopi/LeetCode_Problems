class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = 0, len = nums.length;
        int max = 0, range = 2*k;

        while(r < len){
            while(r < len && nums[r]-nums[l] <= range) r++;
            max = Math.max(max,r-l);
            while(l < len && r < len && nums[r]-nums[l] > range) l++;
        }   
        return max;
    }
}