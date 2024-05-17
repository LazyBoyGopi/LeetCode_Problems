class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int min = Integer.MIN_VALUE;
        Arrays.sort(points,(p1,p2)->(p1[0]-p2[0]));
        for(int i=1;i<points.length;i++){
            int num = points[i][0]-points[i-1][0];
            min = Math.max(min,Math.abs(num));
        }
        return min;
    }
}