class Solution {
    private void getAllSubsets(int[]nums,int idx,List<List<Integer>> list ,List<Integer>temp)
    {
        list.add(new LinkedList<>(temp));
        for(int i=idx;i<nums.length;i++)
        {
            if(i > idx && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            getAllSubsets(nums,i+1,list,temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        getAllSubsets(nums,0,list,new LinkedList<>());
        return list;
    }
}