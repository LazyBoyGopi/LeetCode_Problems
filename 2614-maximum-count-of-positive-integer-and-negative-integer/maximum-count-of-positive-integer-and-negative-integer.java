class Solution {
    public int maximumCount(int[] nums) {
        int posCount = 0, negCount = 0;
        for(int ele : nums){
            if(ele > 0)
                posCount++;
            else if(ele < 0)
                negCount++;
        }
        return Math.max(posCount,negCount);
    }
}