class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length <= 1) return 1;
        int left = 0 , right = 0 ,max = 0 , len = nums.length;
        while(right < len-1){
            max = Math.max(max,right-left+1);

            if(!(nums[right] < nums[right+1])) {
                left = right+1;
            }
            right++;
        }
        return  Math.max(max,right-left+1);
    }
}