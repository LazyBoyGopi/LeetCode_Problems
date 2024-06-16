class Solution {
    public int minPatches(int[] nums, int n) {
        long sum = 0;
        int count = 0, idx = 0 , len = nums.length;
        while(sum < n){
            if(idx < len && nums[idx] <= sum+1){
                sum += nums[idx++];
            }
            else{
                sum +=(sum+1);
                count++;
            }
        }
        return count;
    }
}