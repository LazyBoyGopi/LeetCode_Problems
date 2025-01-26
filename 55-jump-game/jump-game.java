class Solution {
    public boolean canJump(int[] nums) {
        int longJump = 0, len = nums.length;
        if(len == 1) return true;
        for(int i=0;i<len;i++){
            if(longJump < i) return false;
            int curJump = i+nums[i];
            if(curJump > longJump){
                longJump = curJump;
            }
            if(longJump >= len-1) return true;
        }
        return false;
    }
}