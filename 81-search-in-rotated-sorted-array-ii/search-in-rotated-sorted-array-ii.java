class Solution {
    private int getIdx(int[]nums,int target,int st ,int end)
    {
        while(st <= end)
        {
            int mid = st+(end-st)/2;
            if(nums[mid] == target) return mid;
            if(nums[st] == nums[mid] && nums[mid] == nums[end]) {
                st++;
                end--;
                continue;
            }
            if(nums[st] <= nums[mid])
            {
                if(nums[st] <= target && target <= nums[mid]) end = mid-1;
                else st = mid+1;
            }
            else{
                if(nums[mid] <= target && target <= nums[end]) st = mid+1;
               else end = mid-1;
            }
        }
        return -1;
    }
    public boolean search(int[] nums, int target) {
        return getIdx(nums,target,0,nums.length-1) != -1 ? true : false;
    }
}