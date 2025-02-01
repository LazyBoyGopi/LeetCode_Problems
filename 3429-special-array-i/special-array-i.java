class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        boolean isLastOdd = (nums[0] & 1) == 1;
        for(int i=1;i<n;i++){
            boolean isCurOdd = (nums[i] & 1) == 1;
            
            if((isCurOdd && isLastOdd) || (!isCurOdd && !isLastOdd))
                return false;
            isLastOdd = isCurOdd;
        }
        return true;
    }
}