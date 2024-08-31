public class Solution {
    private int Check(int[]nums,int idx){
        int val1 = 51;
        for(int i=0;i<idx;i++){
            if(nums[i] < nums[idx]) val1 = Math.Min(val1,nums[i]);
        }
        int val2 = 51;
        for(int i=idx+1;i<nums.Length;i++){
            if(nums[i] < nums[idx]) val2 = Math.Min(val2,nums[i]);
        }
        return (val1 != 51 && val2 != 51) ? val1+val2 : 0;
    }
    public int MinimumSum(int[] nums) {
        int min = 151;
        for(int i=0;i<nums.Length;i++){
            int curMin=Check(nums,i);
            if(curMin != 0){
                min = Math.Min(min,curMin+nums[i]);
            }
        }
        return min != 151 ? min : -1;
    }
}