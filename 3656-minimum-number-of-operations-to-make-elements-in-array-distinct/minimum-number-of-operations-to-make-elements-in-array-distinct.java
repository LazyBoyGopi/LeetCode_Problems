class Solution {
    private boolean containsDup(int[]map){
        for(int value : map){
            if(value > 1) return true;
        }
        return false;
    }
    private void removeFirstThree(int[]nums,int[]map,int stIdx){
        int len= nums.length;
        if(stIdx == len) return;
        map[nums[stIdx++]]--;
        if(stIdx == len) return;
        map[nums[stIdx++]]--;
        if(stIdx == len) return;
        map[nums[stIdx++]]--;
    }
    public int minimumOperations(int[] nums) {
        int[]map = new int[101];
        int lastRemovedIdx = 0, count = 0;
        for(int i=0;i<nums.length;i++){
            map[nums[i]]++;
        }
        while(containsDup(map)){
            removeFirstThree(nums,map,lastRemovedIdx);
            lastRemovedIdx += 3;
            count++;
        }
        return count;
    }
}