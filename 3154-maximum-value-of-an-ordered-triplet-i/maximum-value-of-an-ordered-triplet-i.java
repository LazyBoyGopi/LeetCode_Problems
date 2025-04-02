class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int len = nums.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        int max = nums[0];
        for(int i=0;i<len;i++){
            max = leftMax[i] = Math.max(nums[i],max);
        }
        max = nums[len-1];
        for(int i=len-1;i>=0;i--){
            max = rightMax[i] = Math.max(max,nums[i]);
        }
        for(int i=1;i<len-1;i++){
            ans = Math.max(ans,((long)(leftMax[i-1])-nums[i])*(rightMax[i+1]));
        }
        return ans;
    }
}