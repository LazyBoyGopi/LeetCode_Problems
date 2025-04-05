class Solution {
    private int xorSum;
    private void getAllSubsets(int []nums,int idx,List<Integer>elements){
        if(idx == nums.length){
            int xor = 0;
            for(int ele : elements){
                xor ^= ele;
            }
            xorSum += xor;
            return;
        }
        elements.add(nums[idx]);
        getAllSubsets(nums,idx+1,elements);
        elements.remove(elements.size()-1);
        getAllSubsets(nums,idx+1,elements);
    }
    public int subsetXORSum(int[] nums) {
        xorSum = 0;
        getAllSubsets(nums,0,new ArrayList());
        return xorSum;
    }
}