class Solution {
    private void getAllSubsets(int[]nums,List<List<Integer>>list,int idx,List<Integer>temp)
    {
        list.add(new LinkedList<>(temp));
        for(int i=idx;i<nums.length;i++)
        {
            if(i > idx && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            getAllSubsets(nums,list,i+1,temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        getAllSubsets(nums,list,0,new LinkedList<>());
        return list;
    }
}