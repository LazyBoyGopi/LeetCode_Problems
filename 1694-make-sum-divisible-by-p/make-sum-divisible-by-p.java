class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0l;
        for(int ele : nums) totalSum += ele;
        int rem = (int)(totalSum%p);
        if(rem == 0) return 0;
        long preSum = 0;
        Map<Integer,Integer>map = new HashMap();
        map.put(0,-1);
        int minLen = nums.length;
        for(int i=0;i<nums.length;i++){
            preSum += nums[i];
            int curMod = (int)(preSum%p);
            int targetMod = (curMod - rem +p)%p;
            if(map.containsKey(targetMod)){
                minLen = Math.min(minLen,i-map.get(targetMod));
            }
            map.put(curMod,i);
        }
        return minLen == nums.length ? -1 : minLen;
    }
}