class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int len = nums.length, s1 = 0, s2 = 0;
        for(int i=0;i<len;i++){
            s1 += nums[i];
            s2 += nums[i];
            max = Math.max(max,s1);
            min = Math.min(min,s2);
            if(s1  < 0) s1 = 0;
            if(s2 > 0) s2 = 0;
        }
        
        return Math.max(Math.abs(min),Math.abs(max));
    }
}