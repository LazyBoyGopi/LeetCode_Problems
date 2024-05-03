class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[]ans = new int[nums.length-k+1];
        Deque<Integer> q = new LinkedList<>();
        int i;
        for(i=0;i<k;i++)
        {
            while(!q.isEmpty() && nums[i] >= nums[q.peekLast()]) q.pollLast();
            q.addLast(i);
        }
        for(;i<nums.length;i++)
        {
            ans[i-k] = nums[q.peekFirst()];
            while(!q.isEmpty() && q.peekFirst() <= i-k) q.pollFirst();
            while(!q.isEmpty() && nums[i] >= nums[q.peekLast()]) q.removeLast();
            q.addLast(i);
        }
        ans[i-k] = nums[q.peekFirst()];
        return ans;
    }
}