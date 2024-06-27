class Solution {
    public int findCenter(int[][] edges) {
        int l1 = -1 , l2 = -1;
        for(int i=0;i<edges.length;i++){
            if(l1 == -1){
                l1 = edges[i][0];
                l2 = edges[i][1];
            }else{
                if(l1 == edges[i][0] || l2 == edges[i][0]) return edges[i][0];
                else if(l1 == edges[i][1] || l2 == edges[i][1]) return edges[i][1];
            }
        }
        return 0;
    }
}