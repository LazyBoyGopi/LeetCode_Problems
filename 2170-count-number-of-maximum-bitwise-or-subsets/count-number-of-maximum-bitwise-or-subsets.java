class Solution {
    int maxORSubsetsCount, maxOR;
    private void getSubsets(int[]nums,int idx,int or){
        if(idx == nums.length){
            if(or > maxOR){
                maxOR = or;
                maxORSubsetsCount = 1;
            }
            else if(or == maxOR){
                maxORSubsetsCount++;
            }
            return;
        }
        getSubsets(nums,idx+1,or | nums[idx]);
        getSubsets(nums,idx+1,or);
    }
    public int countMaxOrSubsets(int[] nums) {
        getSubsets(nums,0,0);
        return maxORSubsetsCount;
    }
}