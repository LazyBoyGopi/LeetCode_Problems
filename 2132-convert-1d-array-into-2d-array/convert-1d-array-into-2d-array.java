class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n != original.length) return new int[0][0];
        int[][]ar = new int[m][n];
        int col = 0, row=0;
        for(int i=0;i<original.length;i++){
            int ele = original[i];
            if(col == n) {
                col = 0;
                row++;
            }
            ar[row][col++] = ele;
        }
        return ar;
    }
}