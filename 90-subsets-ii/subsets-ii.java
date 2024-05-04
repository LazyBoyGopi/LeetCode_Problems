class Solution {
    private void getAllSubsets(int[]nums,int idx,Set<List<Integer>> list ,List<Integer>temp)
    {
        if(idx == nums.length){
            list.add(new LinkedList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        getAllSubsets(nums,idx+1,list,temp);
        temp.remove(temp.size()-1);
        getAllSubsets(nums,idx+1,list,temp);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet<>();
        getAllSubsets(nums,0,list,new LinkedList<>());
        List<List<Integer>> ans = new ArrayList<>(list.size());
        for(List<Integer> l : list)
        {
            ans.add(l);
        }
        return ans;
    }
}