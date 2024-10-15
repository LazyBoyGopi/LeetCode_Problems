class Solution {
    public int alternatingSubarray(int[] nums) {
        int maxLen = 0,len = nums.length;
        for(int i=0;i<len;i++){
            int curLen = 0;
            boolean isEven = true;
            for(int j=i+1;j<len;j++){
                if(isEven){
                    if(nums[j] - nums[j-1] == 1) curLen++;
                    else break;
                }else{
                    if(nums[j] - nums[j-1] == -1) curLen++;
                    else break;
                }
                isEven = !isEven;
            }
            maxLen = Math.max(maxLen,curLen);
        }
        return maxLen != 0 ? maxLen+1 : -1;
    }
}