class Solution {
    private int getSqrt(int num){
        int left = 0, right = num;
        while(left <= right){
            int mid = left+(right-left)/2;
            long mul = (long)mid * mid;
            if(mul == num) return mid;
            if(mul > num) right = mid-1;
            else left = mid+1;
        }
        return right;
    }
    public long pickGifts(int[] gifts, int k) {
        Queue<Integer>queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int gift : gifts) queue.offer(gift);
        while(k > 0){
            int curGift = queue.poll();
            int sqrt = getSqrt(curGift);
            queue.offer(sqrt);
            k--;
        }
        long numberOfRemainingGifts = 0l;
        for(int gift : queue){
            numberOfRemainingGifts += gift;
        }
        return numberOfRemainingGifts;
    }
}