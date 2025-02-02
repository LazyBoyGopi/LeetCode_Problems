/*class Solution {
    public boolean check(int[] nums) {
        int count = 0, len = nums.length;
        int idx = 0;
        for(int i=1;i<len-1;i++){
            if(nums[i] < nums[i-1] && nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }
        System.out.println(idx);

        for(int i=0;i<idx-1;i++){
            if(nums[i] > nums[i+1]) return false;
        }
        System.out.println(idx);

        for(int i=idx;i<len-1;i++){
            if(nums[i] > nums[i+1]) return false;
        }
        int nextEle = idx-1 >= 0 ? nums[idx-1] : Integer.MAX_VALUE;
        int preEle = nums[len-1];
        return preEle <= nextEle;

    }
}*/

class Solution {
    int findPeak(int[]nums)
    {
        int st = 0 , end = nums.length-1;
        while(st <= end)
        {
            int mid = st+(end-st/2);
            if(mid > 0 && nums[mid-1] > nums[mid]) return mid-1;
            if(mid < nums.length-1 && nums[mid] > nums[mid+1]) return mid;
            if(nums[st] >= nums[mid]) end = mid-1;
            else st = mid+1;
        }
        return st;
    }
    boolean isSorted(int[]nums,int st, int end , boolean isFirstHalf)
    {
       if(isFirstHalf)
       {
            for(int i=st;i<end;i++)
            {
                if(i<nums.length-1 && nums[i]>nums[i+1]) return false;
            }
       }
       else
       {
           for(int i=st;i<end;i++)
            {
                if(nums[i]>nums[i+1]) return false;
            }
       }
        return true;
    }
    public boolean check(int[] nums) {
    //    int idx = findPeak(nums);
    //    if(isSorted(nums,0,idx,true) && isSorted(nums,idx+1,nums.length-1,false)) return true;
    //     return false;
        int len = nums.length;
        int count = 0; 
        for(int i=0;i<len;i++)
        {
            if(nums[i] > nums[(i+1)%len])
                count++;
            if(count > 1) return false;
        }
        return true;
    }
}