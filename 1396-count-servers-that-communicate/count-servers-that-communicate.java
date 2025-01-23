class Solution {
    private int[][] getPreSum(int[][]grid){
        int r = grid.length, c = grid[0].length, idx = 0;
        int[]row = new int[r];
        int[]col = new int[c];
        for(int i=0;i<r;i++){
            int rowServerCount = 0;
            for(int j=0;j<c;j++){
                rowServerCount += grid[i][j];
            }
            row[idx++] = rowServerCount;
        }
        idx = 0;
        for(int i=0;i<c;i++){
            int rowServerCount = 0;
            for(int j=0;j<r;j++){
                rowServerCount += grid[j][i];
            }
            col[idx++] = rowServerCount;
        }
        return new int[][]{row,col};
    }
    public int countServers(int[][] grid) {
        int[][]rowsCols = getPreSum(grid);
        int totalCommuicateServers = 0, r = grid.length, c = grid[0].length;
        System.out.println(Arrays.deepToString(rowsCols));
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == 1){
                    int row = rowsCols[0][i]-1, col = rowsCols[1][j]-1;
                    if(row != 0 || col != 0){
                        totalCommuicateServers++;
                    }
                }
            }
        }
        return totalCommuicateServers;
    }
}