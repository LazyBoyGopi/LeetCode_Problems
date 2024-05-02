class Solution {
    private void getAllSubsets(int[]nums,List<List<Integer>> list,List<Integer> temp,int idx)
    {
        list.add(new LinkedList(temp));
        for(int i=idx;i<nums.length;i++)
        {
            temp.add(nums[i]);
            getAllSubsets(nums,list,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        getAllSubsets(nums,list,new LinkedList<Integer>(),0);
        return list;
    }
}