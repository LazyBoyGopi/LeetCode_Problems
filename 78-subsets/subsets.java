class Solution {
    private void getAllSubSets(int[]nums,List<List<Integer>>list,int idx , List<Integer>newList)
    {
        if(idx == nums.length)
        {
            List<Integer>n = new LinkedList(newList);
            list.add(n);
            return;
        }
        newList.add(nums[idx]);
        getAllSubSets(nums,list,idx+1,newList);
        newList.remove(newList.size()-1);
        getAllSubSets(nums,list,idx+1,newList);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> newList = new LinkedList<>();
        getAllSubSets(nums,list,0,newList);
        return list;
    }
}