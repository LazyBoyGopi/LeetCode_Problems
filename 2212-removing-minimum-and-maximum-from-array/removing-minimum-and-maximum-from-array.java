class Solution {
    public int minimumDeletions(int[] nums) {
        int minIdx = -1 , maxIdx = -1 , len = nums.length;
        int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int ele = nums[i];
            if(ele < min) {
                min = ele;
                minIdx = i;
            }
            if(ele > max){
                max = ele;
                maxIdx = i;
            }
        }
        int leftSide = Math.max(minIdx+1,maxIdx+1);
        int rightSide = Math.max(len-minIdx,len-maxIdx);
        int oppSide = Math.min(minIdx+1,len-minIdx)+Math.min(maxIdx+1,len-maxIdx);
        return Math.min(oppSide,Math.min(leftSide,rightSide));
    }
}