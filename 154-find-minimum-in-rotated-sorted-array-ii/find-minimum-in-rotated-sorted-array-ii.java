class Solution {
    public int findMin(int[] nums) {
      int st = 0 , end = nums.length-1;
      while(st <= end)
      {
        int mid = st+(end-st)/2;
        if(mid > 0 && nums[mid-1] > nums[mid]) return nums[mid];
        if(mid < nums.length-1 && nums[mid+1] < nums[mid]) return nums[mid+1];
        if(nums[st] == nums[mid] && nums[mid] > nums[end])
        {
            st = mid+1;
        }
        else if(nums[st] == nums[mid] && nums[mid] == nums[end])
        {
            if(st < nums.length-1 && nums[st] > nums[st+1]) return nums[st+1];
            st++;
            if(end > 0 && nums[end-1] > nums[end]) return nums[end];
            end--;
        }
        else if(nums[st] <= nums[mid] && nums[mid] > nums[end])
        {
            st = mid+1;
        }
        else{
            end = mid-1;
        }
      }  
      if(end == -1) return nums[0];
      return nums[end];
    }
}