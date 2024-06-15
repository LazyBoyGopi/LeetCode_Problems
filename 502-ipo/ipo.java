class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<int[]> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Queue<Integer> maxProfitHeap = new PriorityQueue(Collections.reverseOrder());
        
        for(int i=0;i<profits.length;i++){
            minCapitalHeap.add(new int[]{capital[i],profits[i]});
        }

        for(int i=0;i<k;i++){
            while(!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w){
                maxProfitHeap.add(minCapitalHeap.poll()[1]);
            }
            if(maxProfitHeap.isEmpty()) break;
            w += maxProfitHeap.poll();
        }
        return w;
    }
}