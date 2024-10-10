class Solution {
    public int maxWidthRamp(int[] nums) {
        List<Integer>list = new ArrayList();
        list.add(0);
        int idx = 0;
        int len = nums.length;
        for(int i=1;i<len;i++){
            if(nums[list.get(idx)] > nums[i]){
                list.add(i);
                idx++;
            }
        }
        int maxRamp = 0;
        for(int i=len-1;i>=0 && idx >=0;i--){
            while(idx >= 0 && nums[list.get(idx)] <= nums[i]){
                maxRamp = Math.max(maxRamp,i-list.get(idx));
                idx--; 
            }
        }
        return maxRamp;
    }
}