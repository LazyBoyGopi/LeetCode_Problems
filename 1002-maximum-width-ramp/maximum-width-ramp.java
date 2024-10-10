class Solution {
    public int maxWidthRamp(int[] nums) {
        int maxRamp = 0, len = nums.length;
        List<Integer>stack = new ArrayList();
        stack.add(0);
        for(int i=0;i<len;i++){
            int eleAtI = nums[i];
            int idx = stack.size()-1;
            if(nums[stack.get(idx)]>eleAtI){
                stack.add(i);
            }else{
                while(idx >= 0 && nums[stack.get(idx)] <= eleAtI){
                    idx--;
                }
                maxRamp = Math.max(maxRamp,i-stack.get(idx+1));
            }
        }
        return maxRamp;
    }
}