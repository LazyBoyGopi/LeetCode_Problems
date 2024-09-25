class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] nums1 = new int[len*2];
        int count = 0;
        while(count < 2) {
            int idx = count == 0 ? 0 : len;
            for(int i=0;i<len;i++,idx++){
                nums1[idx] = nums[i];
            }
            count++;
        }
        int[]ans = new int[len*2];
        Arrays.fill(ans,-1);
        Stack<Integer>stack = new Stack();
        int idx = 0;
        len *=2;
        while(idx < len){
            while(!stack.isEmpty() && nums1[stack.peek()] < nums1[idx]){
                ans[stack.pop()] = nums1[idx];
            }   
            stack.push(idx++);
        }
        len/=2;
        int[]ans1 = new int[len];
        for(int i=0;i<len;i++){
            ans1[i] = ans[i];
        }
        return ans1;
    }
}