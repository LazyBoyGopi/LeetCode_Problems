class Solution {
    private int fallingSum(int[][]matrix,int row,int col,int[][]dp){
        if(row == matrix.length) 
            return 0;
        if(col < 0 || col >= matrix.length)
            return Integer.MAX_VALUE;
        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];
        

        int left = fallingSum(matrix,row+1,col-1,dp);
        int right =fallingSum(matrix,row+1,col+1,dp);
        int down = fallingSum(matrix,row+1,col,dp);
        return dp[row][col] = matrix[row][col] + Math.min(down,Math.min(left,right));
    }
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int[][]dp  = new int[matrix.length][matrix.length];
        for(int[]ar : dp) Arrays.fill(ar,Integer.MAX_VALUE);
        for(int i=0;i<matrix.length;i++){
            min = Math.min(min,fallingSum(matrix,0,i,dp));
        }
        return min;
    }
}