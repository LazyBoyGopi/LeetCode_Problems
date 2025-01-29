class Solution {
    int[]parents;
    private int dsuf(int vertice){
        if(parents[vertice] == -1) return vertice;
        return dsuf(parents[vertice]);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parents = new int[n+1];
        Arrays.fill(parents,-1);
        int[]ans = new int[2];
        for(int i=0;i<n;i++){
            int[]edge = edges[i];
            int p1 = dsuf(edge[0]);
            int p2 = dsuf(edge[1]);
            if(p1 == p2){
                ans = edge;
            }else
                parents[p1] = p2;
        }
        return ans;
    }
}