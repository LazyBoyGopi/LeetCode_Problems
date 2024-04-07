class Solution {
    private void transpose(int[][]ar)
    {
        for(int i=0;i<ar.length;i++)
        {
            for(int j=i;j<ar.length;j++)
            {
                int temp = ar[i][j];
                ar[i][j] = ar[j][i];
                ar[j][i] = temp;
            }
        }
    }
    private void swap(int[][]ar)
    {
        for(int i=0;i<ar.length;i++)
        {
            int st = 0 , end = ar.length-1;
            while(st <= end)
            {
                int temp = ar[i][st];
                ar[i][st] = ar[i][end];
                ar[i][end] = temp;
                st++;
                end--;
            }
        }
    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
        swap(matrix);
    }
}