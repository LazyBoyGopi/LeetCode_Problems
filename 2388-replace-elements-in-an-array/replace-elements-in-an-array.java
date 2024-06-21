class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer,Integer>map = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<operations.length;i++){
            int idx = map.get(operations[i][0]);
            int ele = operations[i][1];
            nums[idx] = ele;
            map.put(ele,idx);
        }
        return nums;
    }
}