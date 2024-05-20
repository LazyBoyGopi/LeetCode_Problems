class Solution {
    private int getSubsets(int[]nums,int xor,int idx){
        int sum = 0;
        if(idx == nums.length){
            sum += xor;
            return sum ;
        }
        sum += getSubsets(nums,xor,idx+1);
        xor ^= nums[idx];
        sum += getSubsets(nums,xor,idx+1);
        return sum;
    }
    public int subsetXORSum(int[] nums) {
        
        return getSubsets(nums,0,0);
    }
}