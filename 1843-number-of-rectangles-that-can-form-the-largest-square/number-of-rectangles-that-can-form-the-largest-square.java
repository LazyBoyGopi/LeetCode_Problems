import java.util.*;
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        int count = 0;
        for(int[]ar : rectangles){
            int m = Math.min(ar[0],ar[1]);
           if(max < m){
            max = m;
            count = 1;
           }
           else if(max == m){
            count++;
           }
        }
        return count;
    }
}