class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int len = nums.length, sum = 0;
        for(int i=0;i<len;i++){
            sum += nums[i];
            max = Math.max(max,sum);
            if(sum  < 0) sum = 0;
        }
        sum = 0;
        for(int i=0;i<len;i++){
            sum += nums[i];
            min = Math.min(min,sum);
            if(sum  > 0) sum = 0;
        }
        return Math.max(Math.abs(min),Math.abs(max));
    }
}