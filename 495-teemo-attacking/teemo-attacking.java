class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalTime = 0;
        for(int i=0;i<timeSeries.length-1;i++){
            totalTime += Math.min(timeSeries[i+1]-timeSeries[i],duration);
        }
        totalTime += duration;
        return totalTime;
    }
}