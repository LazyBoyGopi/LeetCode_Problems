class Solution {
    public int countElements(int[] nums) {
        int max = Integer.MIN_VALUE , min = Integer.MAX_VALUE;
        for(int ele : nums){
            min = Math.min(min,ele);
            max = Math.max(max,ele);
        }
        int count = 0;
        for(int ele : nums){
            if(ele < max && ele > min) count++;
        }
        return count;
    }
}