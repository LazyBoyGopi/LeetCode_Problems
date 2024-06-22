class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[]ar = new int[3*10000+1];
        ar[0] = 1;
        int sum = 0 , subarrayCount = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum-goal >= 0) subarrayCount += ar[sum-goal];
            ar[sum]++;

        }
        return subarrayCount;
    }
}