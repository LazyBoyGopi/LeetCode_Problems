class Solution {
    private void getSubsets(int[]nums,List<List<Integer>> list,List<Integer>temp,int idx){
        if(idx == nums.length){
            list.add(new ArrayList(temp));
            return;
        }
        temp.add(nums[idx]);
        getSubsets(nums,list,temp,idx+1);
        temp.remove(temp.size()-1);
        getSubsets(nums,list,temp,idx+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        getSubsets(nums,list,new LinkedList<>(),0);
        return list;
    }
}