class Solution {
    public long pickGifts(int[] gifts, int k) {
        Queue<Integer>q = new PriorityQueue<Integer>((a,b)->b-a);
        long sum = 0l;
        for(int gift : gifts){
            sum += gift;
            q.offer(gift);
        }
        while(k > 0){
            int curEle = q.poll();
            int sqrt = (int)Math.sqrt(curEle);
            sum -= curEle-sqrt;
            q.offer(sqrt);
            k--;
        }
        return sum;
    }
}