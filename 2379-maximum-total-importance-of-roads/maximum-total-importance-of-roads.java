import java.util.*;

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        Map<Integer,Integer>map = new HashMap<>();
        for(int [] ar : roads){
            map.put(ar[0],map.getOrDefault(ar[0],0)+1);
            map.put(ar[1],map.getOrDefault(ar[1],0)+1);
        }
        Collection<Integer> c = map.values();
        int[]ar = new int[c.size()];
        int idx = 0;
        for(int ele : c){
            ar[idx++] = ele;
        }
        Arrays.sort(ar);
        long ans = 0l;
        for(int i=ar.length-1;i>=0;i--){
            int ele = ar[i];
            if(ele == 0) continue;
            ans += ((long)ele * n);
            n--;
        }
        return ans;
    }
}