class Solution {
    private void swap(int[]nums,int r,int l){
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }
    public void sortColors(int[] nums) {
        int left = 0 , mid = 0 , right= nums.length-1;
        while(mid <= right){
            if(nums[mid] == 0){
                swap(nums,mid++,left++);
            }
            else if(nums[mid] == 2){
                swap(nums,mid,right--);
            }
            else mid++;
        }
    }
}