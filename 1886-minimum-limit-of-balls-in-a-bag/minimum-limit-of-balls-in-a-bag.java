class Solution {
    private int findMax(int[]nums){
        int max = nums[0];
        for(int ele : nums) max = Math.max(max,ele);
        return max;
    }
    private int findEle(int[]nums,int target){
        int st = 0,end = nums.length-1;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(nums[mid] < target) st = mid+1;
            else end = mid-1;
        }
        return st;
    }
    private boolean isPossible(int maxBalls,int[]nums, int maxOperations){
        int operationsCount = 0;
        int idx = findEle(nums,maxBalls);
        for(int i=idx;i<nums.length;i++){
            int ele = nums[i];
            int operations = (ele-1)/maxBalls;
            operationsCount += operations;
            if(operationsCount > maxOperations) return false;
        }
        return true;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int st = 1,end = findMax(nums);
        Arrays.sort(nums);
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