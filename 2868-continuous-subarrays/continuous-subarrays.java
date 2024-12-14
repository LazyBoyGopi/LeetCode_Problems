class Solution {
    public long continuousSubarrays(int[] nums) {
        long continuousSubarraysCount = 0;
        Queue<Integer>minHeap = new PriorityQueue<Integer>();
        Queue<Integer>maxHeap = new PriorityQueue<Integer>((a,b)->b-a);
        int left = 0,right = 0,len = nums.length;
        while(right < len){
            int curEle = nums[right];
            minHeap.offer(curEle);
            maxHeap.offer(curEle);
            int minEle = minHeap.peek();
            int maxEle = maxHeap.peek();
            while(maxEle - minEle > 2){
                int leftEle = nums[left++];
                minHeap.remove(leftEle);
                maxHeap.remove(leftEle);
                minEle = minHeap.peek();
                maxEle = maxHeap.peek();
            }
            continuousSubarraysCount += minHeap.size();
            right++;
        }
        return continuousSubarraysCount;
    }

}