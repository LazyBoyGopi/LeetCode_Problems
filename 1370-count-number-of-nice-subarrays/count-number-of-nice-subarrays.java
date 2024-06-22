class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer,Integer>map = new HashMap<>();
        int oddCount = 0 , subarrayCount = 0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            if((nums[i] & 1) == 1){
                oddCount++;
            }
            map.put(oddCount,map.getOrDefault(oddCount,0)+1);
            int comp = oddCount-k;
            if(map.containsKey(comp)){
                subarrayCount += map.get(comp);
            }
        }
        return subarrayCount;
    }
}