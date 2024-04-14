class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for(int ele : nums)
        {
            if(q.size() < k)
            {
                q.add(ele);
            }
            else{
                if(q.peek() < ele)
                {
                    q.poll();
                    q.offer(ele);
                }
            }
        }
        return q.poll();
    }
}