class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int[]idx = new int[(int)1e6+1];
        for(int i=0;i<nums.length;i++){
            idx[nums[i]] = i;
        }
        for(int []ar : operations){
            int index = idx[ar[0]];
            nums[index] = ar[1];
            idx[ar[1]] = index;
        }
        return nums;
    }
}