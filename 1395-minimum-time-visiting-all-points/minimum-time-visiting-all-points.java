class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalDis = 0;
        for(int i=0;i<points.length-1;i++){
            int verDis = Math.abs(points[i+1][0] - points[i][0]);
            int horDis = Math.abs(points[i+1][1] - points[i][1]);
            totalDis += Math.min(verDis,horDis) + Math.abs(verDis-horDis);
        }   
        return totalDis;
    }
}