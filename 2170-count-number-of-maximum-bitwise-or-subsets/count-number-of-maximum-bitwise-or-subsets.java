class Solution {
    private void getAllSubsets(int []nums,int[]ar,int idx,int OR){
        if(idx == nums.length){
            ar[OR]++;
            return;
        }
        getAllSubsets(nums,ar,idx+1,OR);
        getAllSubsets(nums,ar,idx+1,OR | nums[idx]);
    }
    private int getMax(int[]nums){
        int max = nums[0];
        for(int ele : nums) max |= ele;
        return max;
    }
    public int countMaxOrSubsets(int[] nums) {
        int[]ar = new int[getMax(nums)+1];
        getAllSubsets(nums,ar,0,0);
        int max = Integer.MIN_VALUE;
        int maxCount = 0;
        for(int i=ar.length-1;i>=0;i--){
            if(ar[i] != 0){
                return ar[i];
            }
        }
        return -1;
    }
}