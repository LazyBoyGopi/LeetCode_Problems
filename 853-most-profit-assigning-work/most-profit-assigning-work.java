class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][]ar = new int[difficulty.length][2];
        for(int i=0;i<difficulty.length;i++){
            ar[i][0] = difficulty[i];
            ar[i][1] = profit[i];
        }
        Arrays.sort(ar,(a,b) -> a[0]-b[0]);
        Arrays.sort(worker);
        int total = 0;
        int bestSoFar = 0;
        int lastIdx = 0;
        for(int i=0;i<worker.length;i++){
            for(int j=lastIdx;j<ar.length;j++){
                if(worker[i] >= ar[j][0]){
                    lastIdx = j;
                    bestSoFar = Math.max(bestSoFar,ar[j][1]);
                }
            }
            total += bestSoFar;
        }
        return total;
    }
}