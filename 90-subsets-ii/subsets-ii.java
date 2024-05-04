class Solution {
    private void getAllSubsets(int[]nums,int idx,List<List<Integer>> list ,List<Integer>temp)
    {
        if(idx == nums.length){
            if(!list.contains(temp))
            {
                list.add(new LinkedList<>(temp));
            }
            return;
        }
        temp.add(nums[idx]);
        getAllSubsets(nums,idx+1,list,temp);
        temp.remove(temp.size()-1);
        getAllSubsets(nums,idx+1,list,temp);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        getAllSubsets(nums,0,list,new LinkedList<>());
        return list;
    }
}