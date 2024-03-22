class Solution {
    int getMinPathSum(int[][] grid, int[][] dp, int row, int col) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }
        if (dp[row][col] != 0)
            return dp[row][col];
        int sum = grid[row][col];
        if(row == grid.length-1){
           return dp[row][col] = sum + getMinPathSum(grid,dp,row,col+1);
        }
        else if(col == grid[0].length-1)
        {
          return dp[row][col] = sum + getMinPathSum(grid,dp,row+1,col);
        }
        else{
            int rightSum = grid[row][col], downSum = grid[row][col];
            rightSum += getMinPathSum(grid, dp, row, col + 1);
            downSum += getMinPathSum(grid, dp, row + 1, col);
            return dp[row][col] = Math.min(rightSum, downSum);
        }
    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return getMinPathSum(grid, dp, 0, 0);
    }
}