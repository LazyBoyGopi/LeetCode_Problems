class Solution {
    private int getAns(int[]nums,int k,int idx,Map<Integer,Integer>map){
        if(idx == nums.length) {
            return 1;
        }
        int taken = 0;
        if(!map.containsKey(nums[idx]-k) && !map.containsKey(nums[idx]+k)){
            map.put(nums[idx],map.getOrDefault(nums[idx],0)+1);
            taken = getAns(nums,k,idx+1,map);
            map.put(nums[idx],map.get(nums[idx])-1);
            if(map.get(nums[idx]) == 0) map.remove(nums[idx]);
        }
        int notTaken = getAns(nums,k,idx+1,map);
        return taken + notTaken;
    }
    public int beautifulSubsets(int[] nums, int k) {
        return getAns(nums,k,0,new HashMap()) -1;
    }
}