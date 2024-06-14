class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] <= nums[i-1]){
                int increament = nums[i-1]-nums[i]+1;
                count += increament;
                nums[i] += increament;
            }
        }
        return count;
    }
}