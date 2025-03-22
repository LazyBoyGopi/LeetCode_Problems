class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for(int i=0;i<len;i+=2){
            int temp = nums[i+1];
            nums[i+1] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}