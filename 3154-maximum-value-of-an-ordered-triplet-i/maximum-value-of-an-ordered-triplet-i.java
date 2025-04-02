class Solution {
    int len;
    private long getLeftMax(int[]nums,int st){
        long max = 0;
        for(int i=0;i<st;i++){
            max = Math.max(max,nums[i]);
        }
        return max;
    }
    private long getRightMax(int[]nums,int st){
        long max = 0;
        for(int i=st+1;i<len;i++){
            max = Math.max(max,nums[i]);
        }
        return max;
    }
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        len = nums.length;
        for(int i=1;i<len-1;i++){
            long leftMax = getLeftMax(nums,i), rightMax = getRightMax(nums,i);
            ans = Math.max(ans,(leftMax-nums[i])*rightMax);
        }
        return ans;
    }
}