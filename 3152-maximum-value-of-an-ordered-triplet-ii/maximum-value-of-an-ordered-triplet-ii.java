class Solution {
    public long maximumTripletValue(int[] nums) {
        int len = nums.length, max = nums[len-1];
        long ans = 0l;
        int[]maxRight = new int[len];
        for(int i = len-1;i>=0;i--){
            maxRight[i] = max = Math.max(max,nums[i]);
        }
        max = nums[0];
        for(int i=1;i<len-1;i++){
            ans = Math.max(ans,((long)max-nums[i])*maxRight[i+1]);
            max = Math.max(nums[i],max);
        }
        return ans;
    }
}