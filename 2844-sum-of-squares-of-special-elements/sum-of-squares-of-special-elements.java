class Solution {
    public int sumOfSquares(int[] nums) {
        int ans = 0 , len = nums.length;
        for(int i=0;i<len;i++){
            if(len % (i+1) == 0) ans += (nums[i]*nums[i]);
        }
        return ans;
    }
}