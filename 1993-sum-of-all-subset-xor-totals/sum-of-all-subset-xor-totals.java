class Solution {
    int sum = 0;
    private void getSubsets(int[]nums,int xor,int idx){
        if(idx == nums.length){
            sum += xor;
            return;
        }
        getSubsets(nums,xor,idx+1);
        xor ^= nums[idx];
        getSubsets(nums,xor,idx+1);
    }
    public int subsetXORSum(int[] nums) {
        getSubsets(nums,0,0);
        return sum;
    }
}