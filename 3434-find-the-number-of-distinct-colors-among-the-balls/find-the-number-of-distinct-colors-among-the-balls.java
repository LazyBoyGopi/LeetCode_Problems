class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int len = queries.length;
        int[]ans = new int[len];
        int idx = 0;
        Map<Integer,Integer>colors = new HashMap();
        Map<Integer,Integer>freq = new HashMap();
        for(int[]query : queries){

            int o = query[0], t = query[1];
            int curColor = colors.containsKey(o) ? colors.get(o) : -1;

            freq.put(t,freq.getOrDefault(t,0)+1);
            colors.put(o,t);

            if(curColor != -1){
                int times = freq.get(curColor);
                if(times == 1){
                    freq.remove(curColor);
                }else{
                    freq.put(curColor,times-1);
                }
            }
            
            ans[idx++] = freq.size();
        }
        return ans;
    }
}