class Solution {
    void swap(int[]nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    int getPivot(int[]nums,int st,int end)
    {
        int pivot = nums[st];
        int low = st , high = end;
        while(low <= high)
        {
            while(low <= high && nums[low] <= pivot) low++;
            while(high >= st && nums[high] > pivot) high--;
            if(low <= high) swap(nums,low,high);
        }
        swap(nums,st,high);
        return high;
    }
    void quickSort(int[]nums,int st,int end)
    {
        if(st <= end){
            int pivot = getPivot(nums,st,end);
            quickSort(nums,st,pivot-1);
            quickSort(nums,pivot+1,end);
        }
    }
    public int minNumber(int[] nums1, int[] nums2) {
        quickSort(nums1,0,nums1.length-1);
        quickSort(nums2,0,nums2.length-1);
        int first = 0 , second = 0;
        while(first < nums1.length && second < nums2.length)
        {
            if(nums1[first] == nums2[second] ) return nums1[first];
            if(nums1[first] > nums2[second]) second++;
            else first++;
        }
        if(nums1[0] > nums2[0]) return (nums2[0]*10)+nums1[0];
        return (nums1[0]*10)+nums2[0];
    }
}