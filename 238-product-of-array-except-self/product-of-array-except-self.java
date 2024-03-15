
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] preSum = new int[len];
        int[] sufSum = new int[len];
        int[]ans = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0)
                preSum[i] = nums[i];
            else
                preSum[i] = preSum[i-1]*nums[i];
        }
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1)
                sufSum[i] = nums[i];
            else
                sufSum[i] = sufSum[i+1]*nums[i];
        }
        ans[0] = sufSum[1]; 
        ans[len-1] = preSum[len-2];
        for(int i=1;i<len-1;i++)
        {
            ans[i] = preSum[i-1] * sufSum[i+1];
        }
        return ans;
    }
}