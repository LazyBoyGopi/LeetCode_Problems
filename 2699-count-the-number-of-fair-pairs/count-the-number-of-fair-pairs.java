class Solution {
    private int getLowerBound(int[]nums,int upper,int i){
        int st = i, end = nums.length-1;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(nums[mid] > upper) end = mid-1;
            else st = mid+1;
        }
        return end;
    }
    private int getHigherBound(int[]nums,int lower,int i){
        int st = i, end = nums.length-1;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(nums[mid] < lower) st = mid+1;
            else end = mid-1;
        }
        return st;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int len = nums.length;
        long fairPairCount = 0;
        for(int i=0;i<len;i++){
            int highestIdx = getLowerBound(nums,upper-nums[i],i+1);
            int lowerIdx = getHigherBound(nums,lower-nums[i],i+1);
            fairPairCount += (highestIdx-lowerIdx+1);
        }
        return fairPairCount;
    }
}