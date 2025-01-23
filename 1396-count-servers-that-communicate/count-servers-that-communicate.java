class Solution {
    private boolean isRowOrColsPresent(int[][]grid,int i,int j){
        int m = grid.length, n = grid[0].length; 
        for(int row = 0;row<m;row++){
            if(row == i) continue;
            if(grid[row][j] == 1) return true;
        }
        for(int col = 0;col<n;col++){
            if(col == j) continue;
            if(grid[i][col] == 1) return true;
        }
        return false;
    }
    public int countServers(int[][] grid) {

        int totalCommuicateServers = 0, r = grid.length, c = grid[0].length;
        boolean[]rows = new boolean[r];
        boolean[]cols = new boolean[c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == 1){
                    if(rows[i] || cols[j] || isRowOrColsPresent(grid,i,j)){
                        rows[i] = true;
                        cols[j] = true;
                        totalCommuicateServers++;
                    }
                }
            }
        }
        return totalCommuicateServers;
    }
}