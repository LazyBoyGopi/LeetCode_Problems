class Solution {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=1;i<nums.length;i++)
        {
            int target = nums[i]+nums[i-1];
            if(set.contains(target)) return true;
            set.add(target);
        }
        return false;
        // if(nums.length <= 2) return false;
        // for(int i=1;i<nums.length;i++)
        // {
        //     for(int j=i;j<nums.length-1;j++)
        //     {
        //         if(nums[i] + nums[i-1] == nums[j] + nums[j+1]) return true;
        //     }
        // }
        // return false;
    }
}