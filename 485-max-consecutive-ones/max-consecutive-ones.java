class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0 , curMax = 0;
        for(int i=0;i<nums.length;i++){
            int ele = nums[i];
            if(ele == 1) curMax++;
            if(ele == 0 || i == nums.length-1){
                max = Math.max(max,curMax);
                curMax = 0;
            }
        }
        return max;
    }
}