class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length, prev = len-1;
        for(int i=len-2;i>=0;i--){
            if((nums[i]+i) >= prev)
                prev = i;
        }
        return prev == 0;
    }
}