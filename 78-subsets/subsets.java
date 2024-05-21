class Solution {
    private void getSubsets(int[]nums,List<List<Integer>> list,List<Integer>temp,int idx){
        list.add(new LinkedList(temp));
        for(int i=idx;i<nums.length;i++){
            temp.add(nums[i]);
            getSubsets(nums,list,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        getSubsets(nums,list,new LinkedList<>(),0);
        return list;
    }
}