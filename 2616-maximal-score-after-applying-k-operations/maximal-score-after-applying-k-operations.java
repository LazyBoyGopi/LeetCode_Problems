class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer>queue = new PriorityQueue(Comparator.reverseOrder());
        int len = nums.length;
        for(int i=0;i<len;i++) queue.offer(nums[i]);
        long score = 0;
        while(k > 0){
            int curScore = queue.poll();
            queue.offer((int)Math.ceil((curScore*1.0)/3));
            score += curScore;
            k--;
        }
        return score;
    }
}