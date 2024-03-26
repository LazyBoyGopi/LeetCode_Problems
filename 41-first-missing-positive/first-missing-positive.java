class Solution {
    void swap(int[]nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int missing = 1;
        for(int ele : nums)
        {
            if(ele <= 0) continue;
            else if(ele > 0 && ele < missing) continue;
            else if(ele > 0 && ele == missing) missing++;
            else return missing;
        }
        return missing;
    }
}