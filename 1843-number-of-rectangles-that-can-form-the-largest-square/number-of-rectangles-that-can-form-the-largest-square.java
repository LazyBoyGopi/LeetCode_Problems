import java.util.*;
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int[]ar : rectangles){
            int max = Math.min(ar[0],ar[1]);
            map.put(max,map.getOrDefault(max,0)+1);
        }
        int highestNumber = 0 , ans = 0;
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
                int num = m.getKey();
                if(num > highestNumber){
                    highestNumber = num;
                    ans = m.getValue();
                }
            }
        return ans;
    }
}