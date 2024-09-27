class Solution {
    public int partitionDisjoint(int[] nums) {
        int minIdx = 0, len = nums.length, maxEle = nums[0], maxTillNow = maxEle;
        for(int i=1;i<len;i++){
            if(nums[i] < maxEle) {
                minIdx = i;
                maxEle = Math.max(maxTillNow,maxEle);
            }
            else {
                maxTillNow = Math.max(maxTillNow,nums[i]);
            }
        }
        return minIdx+1;
    }
}