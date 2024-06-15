class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        PriorityQueue<Integer>maxProfitHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        
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