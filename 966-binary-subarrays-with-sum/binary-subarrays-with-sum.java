class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        Map<Integer,Integer>map = new HashMap<>();
        map.put(0,1);
        int sum = 0 , subarrayCount = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum-k)) {
                subarrayCount += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return subarrayCount;
    }
}