import java.util.*;
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int[]ar : rectangles){
            int m = Math.min(ar[0],ar[1]);
            map.put(m,map.getOrDefault(m,0)+1);
            max = Math.max(max,m);
        }
        return map.get(max);
    }
}