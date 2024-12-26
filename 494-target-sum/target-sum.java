class Solution {
    int totalPossibilites;
    private void checkAllPossibilites(int[]nums,int idx,int sum,int target){
        if(idx == nums.length){
            if(target == sum) totalPossibilites++;
            return;
        }
        checkAllPossibilites(nums,idx+1,sum-nums[idx],target);
        checkAllPossibilites(nums,idx+1,sum+nums[idx],target);
    }
    public int findTargetSumWays(int[] nums, int target) {
        totalPossibilites = 0;
        checkAllPossibilites(nums,0,0,target);
        return totalPossibilites;
    }
}