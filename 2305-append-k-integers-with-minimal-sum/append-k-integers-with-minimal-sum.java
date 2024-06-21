class Solution {
    public long minimalKSum(int[] nums, int k) {
        long sum = 0;
        Arrays.sort(nums);
        for(int i=1;i<nums[0] && k>0;i++){
            sum += i;
            k--;
        }
        for (int i = 0; i < nums.length - 1 && k > 0; i++) {
            for (int j = nums[i] + 1; j < nums[i + 1] && k > 0; j++) {
                sum += j;
                k--;
            }
        }
        for(int i=nums[nums.length-1]+1;k>0;i++) {
            k--;
            sum += i;
        }
        return sum;
    }
}