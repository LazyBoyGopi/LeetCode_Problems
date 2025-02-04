class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0], curSum = nums[0], last = nums[0],len = nums.length;
        for(int i=1;i<len;i++){
            int curEle = nums[i];
            if(curEle > last){
                curSum += curEle;
            }else{
                max = Math.max(curSum,max);
                curSum = curEle;
            }
            last = curEle;
        }
        return Math.max(curSum,max);
    }
}