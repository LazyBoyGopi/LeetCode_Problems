class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int len = nums.length;
        int[] rightMax = new int[len];
        int max = nums[len-1];
        for(int i=len-1;i>=0;i--){
            max = rightMax[i] = Math.max(max,nums[i]);
        }
        max = nums[0];
        for(int i=1;i<len-1;i++){
            ans = Math.max(ans,((long)max-nums[i])*(rightMax[i+1]));
            max = Math.max(max,nums[i]);
        }
        return ans;
    }
}