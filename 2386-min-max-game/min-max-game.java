class Solution {
    public int minMaxGame(int[] nums) {
        int len = nums.length;
        while(len != 1){
            len /= 2;
            for(int i=0;i<len;i++){
                System.out.println((i ^ 2));
                if(i%2  == 0) nums[i] = Math.min(nums[2*i],nums[2*i+1]);
                else nums[i] = Math.max(nums[2*i],nums[2*i+1]);
            }
            System.out.println(Arrays.toString(nums));
        }
        return nums[0];
    }
}