class Solution {
    public int specialArray(int[] nums) {
        int largest = Integer.MIN_VALUE;
        for(int ele : nums) if(ele > largest) largest = ele;
        int st = 0 , end = largest;
        int count = 0 , mid = 0;
        while(st<=end){
            mid = st+(end-st)/2;
            count = 0;
            for(int ele : nums){
                if(ele >= mid) count++;
            }
            if(mid != 0 && count == mid) return mid;
            if(count > mid){
                st = mid+1;
            }
            else end = mid-1;
        }
        return mid == count ? end : -1;
    }
}