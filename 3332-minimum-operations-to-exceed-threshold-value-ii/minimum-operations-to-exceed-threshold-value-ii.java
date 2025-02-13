class Solution {
    public int minOperations(int[] nums, int k) {
        Queue<Long>pq = new PriorityQueue<Long>();
        for(long ele : nums){
            pq.offer(ele);
        }
        int numOfOper = 0;
        while(pq.size() >= 2 && pq.peek() < k){
            long f = pq.poll(), s = pq.poll();
            long n = Math.min(f,s)*2+Math.max(f,s);
            pq.offer(n);
            numOfOper++;
        }
        return numOfOper;
    }
}