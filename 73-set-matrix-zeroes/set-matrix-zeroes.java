class Solution {
    private void setZeroesAtCol(int[][]matrix,int col)
    {
        for(int i=0;i<matrix.length;i++)
        {
            matrix[i][col] = 0;
        }
    }
    private void setZeroesAtRow(int[][]matrix,int row)
    {
        for(int i=0;i<matrix[0].length;i++)
        {
            matrix[row][i] = 0;
        }
    }
    public void setZeroes(int[][] matrix) {
        int[]row = new int[matrix.length];
        int[]col = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j] == 0)
                {
                    col[j] = 1;
                    row[i] = 1;
                }
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(row[i] == 1 || col[j] == 1)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        // for(int i=0;i<col.length;i++)
        // {
        //     if(col[i] == 1)
        //     {
        //         setZeroesAtCol(matrix,i);
        //     }
        // }
        // for(int i=0;i<row.length;i++)
        // {
        //     if(row[i] == 1)
        //     {
        //         setZeroesAtRow(matrix,i);
        //     }
        // }
    }
}