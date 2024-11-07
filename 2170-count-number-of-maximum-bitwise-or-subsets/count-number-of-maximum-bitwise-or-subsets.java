class Solution {
    private void getAllSubsets(int []nums,Map<Integer,Integer>map,int idx,int OR){
        if(idx == nums.length){
            map.put(OR,map.getOrDefault(OR,0)+1);
            return;
        }
        getAllSubsets(nums,map,idx+1,OR);
        getAllSubsets(nums,map,idx+1,OR | nums[idx]);
    }
    public int countMaxOrSubsets(int[] nums) {
        Map<Integer,Integer>map = new HashMap();
        getAllSubsets(nums,map,0,0);
        int max = Integer.MIN_VALUE;
        int maxCount = 0;
        for(Map.Entry<Integer,Integer>entry : map.entrySet()){
            if(entry.getKey() > max){
                max = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return maxCount;
    }
}