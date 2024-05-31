class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length , max = Integer.MIN_VALUE , sum = 0 , F=0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            F += (i*nums[i]);
        }
        max = Math.max(F,max);
        for(int k=1;k<n;k++){
            F = F+sum - (n*nums[n-k]);
            max = Math.max(max,F);
        }
        return max;
    }
    /*private int getSum(int idx,int[]nums){
        int mul = 0 , sum = 0;
        for(int i=idx;i<nums.length;i++,mul++){
            sum += (mul * nums[i]);
        }
        for(int i=0;i<idx;i++,mul++){
            sum += (mul * nums[i]);
        }
        return sum;
    }
    public int maxRotateFunction(int[] nums) {
        if(nums.length <= 1) return 0;
        int idx = 0 , max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++,idx++){
            max = Math.max(max,getSum(idx,nums));
        }
        return max;
    } */
}