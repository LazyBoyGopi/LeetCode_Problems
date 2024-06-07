class Solution {
    private boolean isPrime(int n){
        if(n == 1) return false;
        for(int i=2;i<n;i++) if(n %i == 0) return false;
        return true;
    }
    public int maximumPrimeDifference(int[] nums) {
        int minIdx = nums.length , maxIdx = -1 , len = nums.length;
        for(int i=0;i<len;i++){
            if(isPrime(nums[i])){
                minIdx = Math.min(minIdx,i);
                maxIdx = Math.max(maxIdx,i);
            }
        }
        if(minIdx == -1 || maxIdx == -1) return 0;
        return maxIdx-minIdx;
    }
}