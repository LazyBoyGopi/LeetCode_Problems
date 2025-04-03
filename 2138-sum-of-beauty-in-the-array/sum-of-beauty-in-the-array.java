class Solution {
    public int sumOfBeauties(int[] nums) {
        int len = nums.length;
        int[] rightMins = new int[len];
        int min = nums[len-1];
        for(int i=len-1;i>=0;i--){
            min = rightMins[i] = Math.min(min,nums[i]);
        }
        int beauty = 0;
        int leftMax = nums[0];
        for(int i=1;i<len-1;i++){
            int curEle = nums[i];
            if(leftMax < curEle && curEle < rightMins[i+1])
                beauty += 2;
            else if(curEle > nums[i-1] && curEle < nums[i+1])
                beauty++;
            leftMax = Math.max(leftMax,curEle);
        }
        return beauty;
    }
}