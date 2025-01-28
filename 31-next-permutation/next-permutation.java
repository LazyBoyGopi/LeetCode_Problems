class Solution {
    private void reverse(int[]nums,int st){
        int end = nums.length-1;
        while(st < end){
            int temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int len = nums.length, r = len-2;
        if(len == 1) return;
        while(r >= 0 && nums[r] >= nums[r+1]) r--;
        if(r >= 0){
            int i=len-1;
            for(;i>r;i--){
                if(nums[i] > nums[r]) break;
            }
            int temp = nums[r];
            nums[r] = nums[i];
            nums[i] = temp;
            reverse(nums,r+1);
        }else{
            reverse(nums,r+1);
        }
    }
}