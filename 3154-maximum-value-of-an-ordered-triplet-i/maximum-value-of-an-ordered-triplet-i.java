class Solution {
    public long maximumTripletValue(int[] nums) {
        long max = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                for(int k=j+1;k<len;k++){
                    long curMax = ((long)nums[i]-nums[j]) * nums[k];
                    if(curMax > max){
                        max = curMax;
                    }
                }
            }
        }
        return max;
    }
}