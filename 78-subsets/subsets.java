class Solution {
    private void getAllSubsets(int[]nums,List<List<Integer>> list,List<Integer> temp,int idx)
    {
        if(idx == nums.length) {
            list.add(new LinkedList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        getAllSubsets(nums,list,temp,idx+1);
        temp.remove(temp.size()-1);
        getAllSubsets(nums,list,temp,idx+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        getAllSubsets(nums,list,new LinkedList<Integer>(),0);
        return list;
    }
}