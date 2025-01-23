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
    private int[][] preCompute(int[][]grid){
        int m = grid.length, n = grid[0].length;
        int[]rows = new int[m];
        int[]cols = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        return new int[][]{rows,cols};
    }
    public int countServers(int[][] grid) {

        int totalCommuicateServers = 0, r = grid.length, c = grid[0].length;
        int[][]isRowOrColsPresent = preCompute(grid);

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == 1){
                    if(isRowOrColsPresent[0][i] > 1 || isRowOrColsPresent[1][j] > 1){
                        totalCommuicateServers++;
                    }
                }
            }
        }
        return totalCommuicateServers;
    }
}


