class Solution {
    private int findMax(int[]nums){
        int max = nums[0];
        for(int ele : nums) max = Math.max(max,ele);
        return max;
    }
    private boolean isPossible(int maxBalls,int[]nums, int maxOperations){
        int operationsCount = 0;
        for(int ele : nums){
            int operations = (ele-1)/maxBalls;
            operationsCount += operations;
            if(operationsCount > maxOperations) return false;
        }
        return true;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int st = 1,end = findMax(nums);
        while(st <= end){
            int mid = (st+end)/2;
            if(isPossible(mid,nums,maxOperations)){
                end = mid-1; 
            }
            else st = mid+1;
        }
        return st;
    }
}