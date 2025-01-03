class Solution {
    public int waysToSplitArray(int[] nums) {
        int len = nums.length;
        long[]sufSum = new long[len];
        long sum = 0;
        for(int i=len-1;i>=0;i--){
            sum += nums[i];
            sufSum[i] = sum;
        }
        int validSplitsCount = 0;
        sum = 0;
        for(int i=0;i<len-1;i++){
            sum += nums[i];
            if(sum >= sufSum[i+1]) 
                validSplitsCount++;
        }
        return validSplitsCount;
    }
}