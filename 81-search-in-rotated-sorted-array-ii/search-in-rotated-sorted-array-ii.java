class Solution {
    private int getPivot(int[]ar)
    {
        int st = 0 , end = ar.length-1;
        while(st <= end)
        {
            int mid = st+(end-st)/2;
            if(mid > 0 && ar[mid-1] > ar[mid]) return mid-1;
            if(mid < ar.length-1 && ar[mid+1] < ar[mid]) return mid;
            if(ar[st] == ar[mid] && ar[end] == ar[mid])
            {
                if(st < ar.length-1 && ar[st] > ar[st+1]) return st;
                st++;
                if(end > 0 && ar[end-1] > ar[end]) return end;
                end--;
            }
            else if(ar[st] < ar[mid] || ar[st] == ar[mid] && ar[mid] > ar[end]) st = mid+1;
            else end = mid-1;
        }
        return -1;
    }
    private boolean isTargetPresent(int[]ar,int st,int end,int target)
    {
        while(st <= end)
        {
            int mid = st+(end-st)/2;
            if(ar[mid] == target) return true;
            if(ar[mid] > target) end = mid-1;
            else st = mid+1;
        }
        return false;
    }
    public boolean search(int[] nums, int target) {
       int pivot = getPivot(nums);
       if(pivot == -1) return isTargetPresent(nums,0,nums.length-1,target);
       if(nums[pivot] == target) return true;
       if(isTargetPresent(nums,0,pivot,target)) return true;
       return isTargetPresent(nums,pivot+1,nums.length-1,target);
    }
}