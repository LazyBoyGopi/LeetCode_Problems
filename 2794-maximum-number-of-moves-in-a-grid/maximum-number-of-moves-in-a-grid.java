class Solution {
    private int check(int[][]grid,int row,int col,int [][]dp){
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int maxMoves = 0;
        int curEle = grid[row][col];
        int m = grid.length;
        int n = grid[0].length;
        if(row < m-1 && col < n-1 && grid[row+1][col+1] > curEle){
            maxMoves = Math.max(maxMoves,1+check(grid,row+1,col+1,dp));
        }
        if(col < n-1 && grid[row][col+1] > curEle){
            maxMoves = Math.max(maxMoves,1+check(grid,row,col+1,dp));
        }
        if(row > 0 && col < n-1 && grid[row-1][col+1] > curEle){
            maxMoves = Math.max(maxMoves,1+check(grid,row-1,col+1,dp));
        }
        return dp[row][col] = maxMoves;
    }
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length, maxMoves = 0;
        int[][]dp = new int[m][n];
        for(int[]ar : dp){
            Arrays.fill(ar,-1);
        }
        
        for(int i=0;i<m;i++){
            maxMoves = Math.max(maxMoves,check(grid,i,0,dp));
        }
        return maxMoves;     
    }
}