class Solution {
    public long mostPoints(int[][] questions) {
        int len = questions.length;
        long[]maxFromHere = new long[len];
        long max = 0l;
        for(int i=len-1;i>=0;i--){
            int j = i+questions[i][1]+1;
            long ifTaken = questions[i][0] + (j >= len ? 0 : maxFromHere[j]);
            max = maxFromHere[i] = Math.max(max,ifTaken);
        }
        return max;
    }
}