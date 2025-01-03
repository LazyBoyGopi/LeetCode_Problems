class Solution {
    public int waysToSplitArray(int[] nums) {
        int len = nums.length;
        long tSum = 0;
        for(int i=len-1;i>=0;i--){
            tSum += nums[i];
        }
        int validSplitsCount = 0;
        long leftSum = 0;
        for(int i=0;i<len-1;i++){
            leftSum += nums[i];
            if(leftSum >= (tSum-leftSum)) 
                validSplitsCount++;
        }
        return validSplitsCount;
    }
}