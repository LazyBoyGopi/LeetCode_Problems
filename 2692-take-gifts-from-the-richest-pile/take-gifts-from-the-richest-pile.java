class Solution {
    private int getMaxElementInArray(int[]nums){
        int max = nums[0], idx = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] > max){
                max = nums[i];
                idx = i;
            }
        }
        return idx;
    }
    public long pickGifts(int[] gifts, int k) {
        for(int i=0;i<k;i++){
            int maxIdx = getMaxElementInArray(gifts);
            int sqrt = (int)Math.sqrt(gifts[maxIdx]);
            gifts[maxIdx] = sqrt;
        }
        long ans = 0l;
        for(int gift : gifts) ans += gift;
        return ans;
    }
}