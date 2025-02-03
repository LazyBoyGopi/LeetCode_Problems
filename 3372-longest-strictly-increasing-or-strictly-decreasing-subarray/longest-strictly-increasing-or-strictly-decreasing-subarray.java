class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLen = 0, len = nums.length,curInc = 0, curDec = 0;
        for(int i=0;i<len-1;i++){
            if(nums[i] > nums[i+1]){
                curInc++;
            }else{
                maxLen = Math.max(maxLen,curInc);
                curInc = 0;
            }
            if(nums[i] < nums[i+1]){
                curDec++;
            }else{
                maxLen = Math.max(maxLen,curDec);
                curDec = 0;
            }
        }
        return Math.max(maxLen,Math.max(curDec,curInc))+1;
    }
}