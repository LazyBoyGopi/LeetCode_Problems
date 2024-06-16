class Solution {
    public int minPatches(int[] nums, int n) {
        long sum = 0 ;
        int idx = 0 , count = 0;
        while(sum < n ){
            if(idx < nums.length && nums[idx] <= sum +1){
                sum += nums[idx++];
            }
            else{
                count++;
                sum += (sum+1);
            }
        }
        return count;
    }
}