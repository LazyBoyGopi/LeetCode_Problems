class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer>stack = new Stack<>();
        int idx = 0 , max = 0;
        while(idx < heights.length)
        {
            if(stack.isEmpty() || heights[stack.peek()] <= heights[idx]) stack.push(idx++);
            else{
                max = Math.max(max , (heights[stack.pop()] * (stack.isEmpty() ? idx : idx-stack.peek()-1)));
            }
        }
        while(!stack.isEmpty()){
            max = Math.max(max,(heights[stack.pop()] * (stack.isEmpty() ? idx : idx-stack.peek()-1)));
        }
        return max;
    }
}