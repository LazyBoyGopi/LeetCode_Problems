class Solution {
    public boolean findSubarrays(int[] nums) {
        if(nums.length <= 2) return false;
        for(int i=1;i<nums.length;i++)
        {
            for(int j=i;j<nums.length-1;j++)
            {
                if(nums[i] + nums[i-1] == nums[j] + nums[j+1]) return true;
            }
        }
        return false;
        // for(int i=1;i<nums.length-1;i++)
        // {
        //     if(nums[i-1]+nums[i] == nums[i+1]+nums[i]) return true;
        // }
        // return false;
    }
}