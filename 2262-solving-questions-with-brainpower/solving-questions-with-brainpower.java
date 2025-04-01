class Solution {
    public long mostPoints(int[][] questions) {
        int len = questions.length;
        long[]maxFromHere = new long[len];
        long max = 0l;
        for(int i=len-1;i>=0;i--){
            long ifTaken = questions[i][0] + ((i+questions[i][1]+1) >= len ? 0 : maxFromHere[i+questions[i][1]+1]);
            max = maxFromHere[i] = Math.max(max,ifTaken);
        }
        return max;
    }
}