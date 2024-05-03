class Solution {
    private int getArea(int[]heights,int len)
    {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int idx = 0;
        while(idx < len){
            if(stack.isEmpty() || heights[stack.peek()] <= heights[idx])
            {
                stack.push(idx++);
            }
            else{
                int area = heights[stack.pop()] * (stack.isEmpty() ? idx : idx-stack.peek()-1);
                max = Math.max(max,area);
            }
        }
        while(!stack.isEmpty()){
            max = Math.max(max,heights[stack.pop()] * (stack.isEmpty() ? idx : idx-stack.peek()-1));
        }
        return max;
    }
    public int largestRectangleArea(int[] heights) {
        return getArea(heights,heights.length);
    }
}