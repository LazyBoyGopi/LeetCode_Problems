class Solution {
    public int minOperations(int[] nums) {
       int minOperations = 0, len = nums.length;
       for(int i=0;i<len-2;i++){
        if(nums[i] == 0){
                minOperations++;
                nums[i+1] = nums[i+1] == 0 ? 1 : 0;
                nums[i+2] = nums[i+2] == 0 ? 1 : 0;
            }
       }
       int zCount = 0;
       for(int i=len-1;i>=len-2;i--){
        if(nums[i] == 0) zCount++;
       }
       System.out.println(zCount+" "+minOperations);
       return zCount == 0 ? minOperations : -1;
    }
}