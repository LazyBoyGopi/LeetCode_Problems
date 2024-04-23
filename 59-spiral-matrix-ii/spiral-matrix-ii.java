class Solution {
    public int[][] generateMatrix(int n) {
        int[][]ar = new int[n][n];
        int top = 0 , bottom = n-1 , left = 0 , right = n-1;
        int num=1;
        while(top <= bottom && left <= right)
        {
            for(int i=left;i<=right;i++)
            {
                ar[top][i] = num++;
            }
            top++;
            for(int i=top;i<=bottom;i++)
            {
                ar[i][right] = num++;
            }
            right--;
            for(int i=right;i>=left;i--)
            {
                ar[bottom][i] = num++;
            }
            bottom--;
            for(int i=bottom;i>=top;i--)
            {
                ar[i][left] = num++;
            }
            left++;
        }
        return ar;
    }
}