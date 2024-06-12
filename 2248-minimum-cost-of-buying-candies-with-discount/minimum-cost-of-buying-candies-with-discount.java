class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int totalCost = 0 , count = 0;

        for(int i=cost.length-1;i>=0;i--){
            if(count == 2){
                count = 0;
                continue;
            }
            totalCost += cost[i];
            count++;
        }   
        return totalCost;
    }
}