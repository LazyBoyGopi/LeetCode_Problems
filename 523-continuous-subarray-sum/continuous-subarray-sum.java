class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int rem = k==0 ? sum : sum%k;
            if(map.containsKey(rem)){
                if(i-map.get(rem) >1) return true;
            }
            else map.put(rem,i);
        }
        return false;
    }
}