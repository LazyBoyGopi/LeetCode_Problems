class Solution {
    private int getSubsets(int[]nums,int xor,int idx){
        if(idx == nums.length) return xor;
        return getSubsets(nums,xor^nums[idx],idx+1) + getSubsets(nums,xor,idx+1);
    }
    public int subsetXORSum(int[] nums) {
        return getSubsets(nums,0,0);
    }
}