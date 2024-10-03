class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            sum += nums[i];
        }
        int rem = (int)(sum % p), minLen = len;
        if(rem == 0) return 0;
        Map<Integer,Integer>map = new HashMap();
        map.put(0,-1);
        long preSum = 0;
        for(int i=0;i<len;i++){
            preSum += nums[i];
            int currentMod = (int)(preSum%p);
            int targetMod = currentMod - rem;
            if(targetMod < 0) targetMod += p;
            if(map.containsKey(targetMod)){
                minLen = Math.min(minLen,i-map.get(targetMod));
            }
            map.put(currentMod,i);
        }
        return minLen == len ? -1 : minLen;
    }
}