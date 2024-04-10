class Solution {
    public void rotate(int[][] matrix) {
        int[][]ans = new int[matrix.length][matrix.length];
        int col = matrix.length-1;
        for(int i=0;i<matrix.length;i++)
        {
            int row = 0;
            for(int j=0;j<matrix[i].length;j++)
            {
                ans[row][col] = matrix[i][j];
                row++;
            }
            col--;
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                matrix[i][j] = ans[i][j];
            }
        }
    }
}