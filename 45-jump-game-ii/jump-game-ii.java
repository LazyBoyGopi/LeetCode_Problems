class Solution {
    public int jump(int[] nums) {
        int jump = 0,nextJump = 0, steps = 0,len = nums.length;
        for(int i=0;i<len;i++){
            int curJump = i+nums[i];
            if(i>jump){
                jump = nextJump;
                steps++;
            }
            if(curJump > nextJump){
                nextJump = curJump;
            }
            if(jump >= len-1) return steps;
        }
        return steps;
    }
}