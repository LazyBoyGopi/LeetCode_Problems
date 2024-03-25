class Solution {
    void swap(int i,int j,int[] nums)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public List<Integer> findDuplicates(int[] nums) {
        int st= 1;
        List<Integer> list = new LinkedList<>();
        while(st < nums.length)
        {
            if(nums[st] != st+1 && nums[nums[st]-1] != nums[st]) swap(st,nums[st]-1,nums);
            else st++; 
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] != i+1) list.add(nums[i]);
        }
        return list;
    }
}