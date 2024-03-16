class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = nums[0];
        for(int i=1;i<len;i++)
        {
            ans[i] = ans[i-1]*nums[i];
        }
        for(int i=len-2;i>=0;i--)
        {
            nums[i] *= nums[i+1]; 
        }
        nums[0] = nums[1];
        for(int i=1;i<len-1;i++)
        {
            nums[i] = nums[i+1] * ans[i-1];
        }
        nums[len-1] = ans[len-2];
        return nums;
    }
}