class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[]ar = new int[(int)5e4+1];
        ar[0] = 1;
        int oddCount = 0 , subarrayCount = 0;
        for(int i=0;i<nums.length;i++){
            if((nums[i] & 1) == 1) oddCount++;
            ar[oddCount]++;
            if(oddCount-k >= 0)
                subarrayCount += ar[oddCount-k];
        }
        return subarrayCount;
    }
}