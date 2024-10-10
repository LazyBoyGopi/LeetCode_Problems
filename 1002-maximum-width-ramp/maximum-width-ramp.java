class Solution {
    public int maxWidthRamp(int[] nums) {
        int len = nums.length;
        Stack<Integer>stack = new Stack();
        stack.push(0);
        for(int i=1;i<len;i++){
            if(nums[stack.peek()] > nums[i]) stack.add(i);
        }
        int maxRamp = 0;
        for(int i=len-1;i>=0;i--){
            int ele = nums[i];
            while(!stack.isEmpty() && nums[stack.peek()] <= ele) {
                maxRamp = Math.max(maxRamp, i-stack.peek());
                stack.pop();
            }
        }
        return maxRamp;
    }
}