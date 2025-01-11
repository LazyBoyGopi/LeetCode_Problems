class Solution {
    private void conquer(int[]nums,int st,int mid,int end){
        int[] temp = new int[end-st+1];
        int p=0, p1=st,p2=mid+1;
        while(p1 <= mid && p2 <= end){
            if(nums[p1] < nums[p2]){
                temp[p++] = nums[p1++];
            }else{
                temp[p++] = nums[p2++];
            }
        }
        while(p1 <= mid){
            temp[p++] = nums[p1++];
        }
        while(p2 <= end){
            temp[p++] = nums[p2++];
        }
        for(int i=st,j=0;j<temp.length;i++,j++){
            nums[i] = temp[j];
        }
    }
    private void mergeSort(int[]nums,int st,int end){
        if(st >= end) return;
            int mid = st+(end-st)/2;
            mergeSort(nums,st,mid);
            mergeSort(nums,mid+1,end);
            conquer(nums,st,mid,end);
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}