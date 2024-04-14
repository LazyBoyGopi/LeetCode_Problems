class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer>q = new PriorityQueue<Integer>();
        for(int ele : nums)
        {
            if(q.size() < k)
            {
                q.offer(ele);
            }
            else{
                if(ele > q.peek()){
                    q.poll();
                    q.offer(ele);
                }
            }
        }
        return q.poll();
    }
}