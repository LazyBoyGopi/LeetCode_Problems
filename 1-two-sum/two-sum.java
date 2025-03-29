class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        int len = nums.length;
        for(int i=0;i<len;i++){
            int ele = nums[i], comp = target-ele;
            if(map.containsKey(comp)){
                return new int[]{map.get(comp),i};
            }
            map.put(ele,i);
        }
        return nums;
    }
}