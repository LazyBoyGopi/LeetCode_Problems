class Solution {
    public int searchInsert(int[] nums, int target) {
        int st = 0 , end = nums.length-1;
        while(st <= end)
        {
            int mid = st+(end-st)/2;
            if(nums[mid] == target) return mid;
            if(mid > 0 && nums[mid] > target && nums[mid-1] < target) return mid;
            if(nums[mid] > target) end = mid-1;
            else st = mid+1;
        }
        return st;
    }
}