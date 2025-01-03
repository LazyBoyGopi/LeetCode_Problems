class Solution {
    public int waysToSplitArray(int[] nums) {
        int len = nums.length;
        long[]sufSum = new long[len];
        sufSum[len-1] = nums[len-1];
        for(int i=len-2;i>=0;i--){
            sufSum[i] = sufSum[i+1] + nums[i];
        }
        int validSplitsCount = 0;
        long sum = 0;
        for(int i=0;i<len-1;i++){
            sum += nums[i];
            if(sum >= sufSum[i+1]) 
                validSplitsCount++;
        }
        return validSplitsCount;
    }
}