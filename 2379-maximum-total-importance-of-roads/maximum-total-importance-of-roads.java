class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[]ar = new int[5*(int)1e4];
        int len = roads.length;
        for(int i=0;i<len;i++){
            ar[roads[i][0]]++;
            ar[roads[i][1]]++;
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