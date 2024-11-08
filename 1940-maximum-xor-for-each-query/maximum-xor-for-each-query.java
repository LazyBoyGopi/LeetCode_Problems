class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
     int max = (1<<maximumBit)-1;
     int len = nums.length;
     for(int i=1;i<len;i++){
        nums[i] ^= nums[i-1]; 
     }
     int[]ar = new int[len];
     for(int i=len-1;i>=0;i--){
        
        
        ar[len-i-1] = (nums[i]^max);
     }
     return ar;
    }
}