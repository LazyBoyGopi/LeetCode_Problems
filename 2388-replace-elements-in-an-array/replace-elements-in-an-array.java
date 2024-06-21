class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer,Integer>map = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int [] ar : operations){
            int idx = map.get(ar[0]);
            nums[idx] = ar[1];
            map.remove(ar[0]);
            map.put(ar[1],idx);
        }
        return nums;
    }
}