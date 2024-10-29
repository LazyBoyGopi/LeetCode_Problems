class Solution {
    private int check(int[][]grid,int row,int col,int [][]dp){
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int maxMoves = 0;
        if(row < grid.length-1 && col < grid[0].length-1 && grid[row+1][col+1] > grid[row][col]){
            maxMoves = Math.max(maxMoves,1+check(grid,row+1,col+1,dp));
        }
        if(col < grid[0].length-1 && grid[row][col+1] > grid[row][col]){
            maxMoves = Math.max(maxMoves,1+check(grid,row,col+1,dp));
        }
        if(row > 0 && col < grid[0].length-1 && grid[row-1][col+1] > grid[row][col]){
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
        for(int[]ar : dp){
            System.out.println(Arrays.toString(ar));
        }   
        return maxMoves;     
    }
}