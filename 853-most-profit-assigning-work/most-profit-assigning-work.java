class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<int[]>diff = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        PriorityQueue<Integer>maxProfit = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<difficulty.length;i++){
            diff.add(new int[]{difficulty[i],profit[i]});
        }
        int total = 0;
        Arrays.sort(worker);
        for(int i=0;i<worker.length;i++){
            while(!diff.isEmpty() && diff.peek()[0] <= worker[i]){
                maxProfit.add(diff.poll()[1]);
            }
            if(!maxProfit.isEmpty())
            total += maxProfit.peek();
        }
        return total;
    }
}