class Solution {
    private int xorSum;
    private void getAllSubsets(int []nums,int idx,int xor){
        if(idx == nums.length){
            xorSum += xor;
            return;
        }
        getAllSubsets(nums,idx+1,xor ^ nums[idx]);
        getAllSubsets(nums,idx+1,xor);
    }
    public int subsetXORSum(int[] nums) {
        xorSum = 0;
        getAllSubsets(nums,0,0);
        return xorSum;
    }
}