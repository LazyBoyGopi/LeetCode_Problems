class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;)
        {
            for(int j=i+1;j<nums.length;)
            {
                int k=j+1 , l = nums.length-1;
                while(k < l)
                {
                    long sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(target == sum)
                    {
                        list.add(new LinkedList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[l])));
                        k++;
                        l--;
                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }
                    else if(sum > target) l--;
                    else k++;
                }
                j++;
                while(j < nums.length && nums[j] == nums[j-1])j++;
            }
            i++;
            while(i < nums.length && nums[i] == nums[i-1]) i++;
        }
        return list;
    }
}