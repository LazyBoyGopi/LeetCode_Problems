class Solution {
    private void conquer(int[]nums,int st,int mid,int end)
    {
        int[] ar = new int[end-st+1];
        int idx = 0 , idx1 = st , idx2 = mid+1;
        while(idx1 <= mid && idx2 <= end)
        {
            if(nums[idx1] < nums[idx2])
            {
                ar[idx++] = nums[idx1++];
            }
            else{
                ar[idx++] = nums[idx2++];
            }
        }
        while(idx1 <= mid)
        {
            ar[idx++] = nums[idx1++];
        }
        while(idx2 <= end)
        {
            ar[idx++] = nums[idx2++];
        }
        for(int i=0,j=st;i<ar.length;i++,j++)
        {
            nums[j] = ar[i];
        }
    }
    private int getPairs(int[]nums,int st,int mid,int end)
    {
        int right = mid+1;
        int count=0;
        for(int i=st;i<=mid;i++)
        {
            while(right<=end && nums[i] > 2*(long)nums[right])
           {
             right++;
           }
            count += right-(mid+1);
        }
        return count;
    }
    private int mergeSort(int[]nums,int st, int end)
    {
        int count = 0;
        if(st >= end) return count;
        int mid = st+(end-st)/2;
        count += mergeSort(nums,st,mid);
        count += mergeSort(nums,mid+1,end);
        count += getPairs(nums,st,mid,end);
        conquer(nums,st,mid,end);
        return count;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
}