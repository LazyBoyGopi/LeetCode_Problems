class Solution {
    private void conquer(int[]nums,int st,int mid,int end){
        int[]temp = new int[end-st+1];
        int idx = 0 , idx1 = st , idx2 = mid+1;
        while(idx1 <= mid && idx2 <= end){
            if(nums[idx1] > nums[idx2]){
                temp[idx++] = nums[idx2++];
            }
            else temp[idx++] = nums[idx1++];
        }
        while(idx1 <= mid){
            temp[idx++] = nums[idx1++];
        }
        while(idx2 <= end){
            temp[idx++] = nums[idx2++];
        }
        for(int j=st,i=0;i<temp.length;j++,i++){
            nums[j] = temp[i];
        }
    }
    private void helperMergeSort(int[]nums,int st,int end){
        if(st >= end) return ;
        else 
        {
            int mid = st+(end-st)/2;
            helperMergeSort(nums,st,mid);
            helperMergeSort(nums,mid+1,end);
            conquer(nums,st,mid,end);
        }
    }
    private void mergeSort(int[]nums){
        helperMergeSort(nums,0,nums.length-1);
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;
    }
}