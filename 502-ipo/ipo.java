/*class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<List<Integer>>list = new LinkedList<>();
        int totalProfit = w;
        for(int i=0;i<profits.length;i++){
            list.add(Arrays.asList(profits[i],capital[i]));
        }
        Collections.sort(list,(a,b) -> Integer.compare(b.get(0),a.get(0)));
       
        while(k > 0){
            boolean isPossible = false;
            for(int i=0;i<list.size();i++){
                if(list.get(i).get(1) <= w){
                    w += list.get(i).get(0);
                    totalProfit += list.get(i).get(0);
                    list.remove(i);
                    k--;
                    isPossible = true;
                    break;
                }
            }
            if(!isPossible) break;
        }
        return totalProfit;
    }
} */
class Solution{
     public int findMaximizedCapital(int k, int w, int[] profits, int[] capital)    {
        PriorityQueue<int[]>minHeapCapital = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        PriorityQueue<Integer>maxHeapProfit = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<profits.length;i++){
            minHeapCapital.add(new int[]{capital[i],profits[i]});
        }
        for(int i=0;i<k;i++){
            while(!minHeapCapital.isEmpty() && minHeapCapital.peek()[0] <= w){
                maxHeapProfit.add(minHeapCapital.poll()[1]);
            }
            if(maxHeapProfit.isEmpty()) break;
            w += maxHeapProfit.poll();
        }
        return w;
     }
}