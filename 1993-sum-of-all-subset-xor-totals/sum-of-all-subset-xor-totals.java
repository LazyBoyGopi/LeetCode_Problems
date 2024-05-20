class Solution {
    private void getSubsets(int[]nums,List<List<Integer>>list,List<Integer>temp,int idx){
        if(idx == nums.length){
            list.add(new ArrayList(temp));
            return;
        }
        temp.add(nums[idx]);
        getSubsets(nums,list,temp,idx+1);
        temp.remove(temp.size()-1);
        getSubsets(nums,list,temp,idx+1);
    }
    private int ans(int[]nums){
        List<List<Integer>> list = new LinkedList<>();
        getSubsets(nums,list,new ArrayList(),0);
        int sum = 0;
        for(List<Integer> l : list){
            int xor = 0;
            for(int i : l){
                xor ^= i;
            }
            sum += xor;
        }
        return sum;
    }
    public int subsetXORSum(int[] nums) {
        return ans(nums);
    }
}