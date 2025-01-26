class Solution {
    public boolean canJump(int[] nums) {
        int longJump = 0, len = nums.length;
        if(len == 1) return true;
        for(int i=0;i<len;i++){
            if(longJump < i) return false;
            longJump = Math.max(longJump,i+nums[i]);
        }
        return true;
    }
}