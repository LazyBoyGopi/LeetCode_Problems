class Solution {
    void swap(int[]nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    int getPivot(int[]nums,int low , int high)
    {
        int pivot = nums[low];
        int i = low , j = high;
        while(i<j)
        {
            while(i <= high && nums[i] <= pivot) i++;
            while(j >= low && nums[j] > pivot) j--;
            if(i<j) swap(nums,i,j);
        }
        swap(nums,low,j);
        return j;
    }
    void sort(int[]nums,int low,int high){
       
       if(low <= high)
       {
        int pivot = getPivot(nums,low,high);
       sort(nums,low,pivot-1);
       sort(nums,pivot+1,high);
       }
    }
    public int minimumBoxes(int[] apple, int[] capacity) {
        int len = capacity.length;
       sort(capacity,0,len-1);
        int sum = 0;
        for(int apples : apple) sum += apples;
        for(int i=len-1;i>=0;i--)
        {
            sum -= capacity[i];
            if(sum <= 0) return len-i;
        }
        return -1;
    }
}