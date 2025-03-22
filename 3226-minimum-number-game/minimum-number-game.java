class Solution {
    public int[] numberGame(int[] nums) {
        Queue<Integer>queue = new PriorityQueue();
        for(int ele : nums){
            queue.offer(ele);
        }
        int idx = 0;
        while(!queue.isEmpty()){
            int first = queue.poll();
            int second = queue.poll();
            nums[idx++] = second;
            nums[idx++] = first;
        }
        return nums;
    }
}