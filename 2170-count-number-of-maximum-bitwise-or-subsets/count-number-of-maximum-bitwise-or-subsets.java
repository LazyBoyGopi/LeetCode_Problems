class Solution {
    int[]ar = new int[1];
    private void getAllSubsets(int []nums,int idx,int OR,int maxOR){
        if(OR == maxOR){
            ar[0]++;
        }
        for(int i=idx;i<nums.length;i++){
            getAllSubsets(nums,i+1,OR | nums[i],maxOR);
        }
    }
    private int getMaxOR(int[]nums){
        int max = 0;
        for(int ele : nums) max |= ele;
        return max;
    }
    public int countMaxOrSubsets(int[] nums) {
        ar[0] = 0;
        int maxOR = getMaxOR(nums);
        getAllSubsets(nums,0,0,maxOR);
        return ar[0];
    }
}