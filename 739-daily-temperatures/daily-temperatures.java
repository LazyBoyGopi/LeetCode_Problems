class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer>stack = new Stack();
        int len = temperatures.length;
        int[]wait = new int[len];
        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                int idx = stack.pop();
                wait[idx] = i-idx;
            }
            stack.push(i);
        }
        return wait;
    }
}