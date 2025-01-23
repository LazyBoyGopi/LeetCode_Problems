/*

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

class Solution {
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

 */


class Solution {
    public int countServers(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];

        // First pass: Count the number of servers in each row and column
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int totalCommunicatingServers = 0;

        // Second pass: Check which servers can communicate
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // A server can communicate if there is more than one server in its row or column
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    totalCommunicatingServers++;
                }
            }
        }

        return totalCommunicatingServers;
    }
}
