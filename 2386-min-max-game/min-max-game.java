class Solution {
    public int minMaxGame(int[] nums) {
        int len = nums.length;
        while(len != 1){
            len /= 2;
            for(int i=0;i<len;i++){
                if((i&1) == 0) nums[i] = Math.min(nums[2*i],nums[2*i+1]);
                else nums[i] = Math.max(nums[2*i],nums[2*i+1]);
            }
        }
        return nums[0];
    }
}