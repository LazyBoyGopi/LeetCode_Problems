class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean ar[] = new boolean[n];
        for(int []edge : edges){
            ar[edge[1]] = true;
        }
        int count = 0;
        int ans = -1;
        for(int i=0;i<ar.length;i++){

            if(!ar[i]) {
                count++;
                ans = i;
                if(count > 1) return -1;
            }
        }
    return ans;
    }
}