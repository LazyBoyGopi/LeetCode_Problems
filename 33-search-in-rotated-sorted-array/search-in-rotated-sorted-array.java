class Solution {
    private int getPivot(int[]ar,int target)
    {
        int st = 0 , end = ar.length-1;
        while(st <= end)
        {
            int mid = st+(end-st)/2;
            if(ar[mid] == target) return mid;
            if(mid < ar.length-1 && ar[mid] > ar[mid+1]) return mid+1;
            if(mid > 0 && ar[mid] < ar[mid-1]) return mid;
            if(ar[mid] > ar[st]) st = mid+1;
            else end = mid-1;
        }
        return st;
    }
    private int binarySearch(int[]nums,int target,int st , int end )
    {
        while(st <= end)
        {
            int mid = st+(end-st)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) end = mid-1;
            else st = mid+1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int idx = getPivot(nums,target);
        System.out.println(idx);
        if(idx == nums.length || idx == 0) return binarySearch(nums,target,0,nums.length-1);
        if(target == nums[idx]) return idx;
        if(target >= nums[0] && target <= nums[idx-1]) return binarySearch(nums,target,0,idx-1);
        return binarySearch(nums,target,idx+1,nums.length-1);
    }
}