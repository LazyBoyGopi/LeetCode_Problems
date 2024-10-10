class Solution {
    public int maxWidthRamp(int[] nums) {
        int maxRamp = 0, len = nums.length;
        List<Integer>stack = new LinkedList();
        stack.add(0);
        for(int i=0;i<len;i++){
            int eleAtI = nums[i];
            if(nums[stack.get(stack.size()-1)]>eleAtI){
                stack.add(i);
            }else{
                int idx = stack.size()-1;
                while(idx >= 0 && nums[stack.get(idx)] <= eleAtI){
                    maxRamp = Math.max(maxRamp,i-stack.get(idx--));
                }
            }
        }
        return maxRamp;
    }
}