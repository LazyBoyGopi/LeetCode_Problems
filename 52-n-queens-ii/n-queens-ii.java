class Solution {
    int numberOfWays = 0;

    private void canWePlaceNQueens(int n, int[][] mat, int curRow) {
        if (curRow == n) {
            numberOfWays++;
            return;
        }
        outer : for (int j = 0; j < n; j++) {

            int curCol = j;

           for (int i = 0; i < n; i++) {
                if (mat[i][curCol] == 1)
                     continue outer;
            }

            for(int r=curRow,c=curCol; r>=0 && c>=0; r--,c--){
                if(mat[r][c] == 1) continue outer;
            }

            for(int r=curRow,c=curCol; r>=0 && c<n; r--,c++){
                if(mat[r][c] == 1) continue outer;
            }

            mat[curRow][curCol] = 1;
            canWePlaceNQueens(n, mat, curRow + 1);
            mat[curRow][curCol] = 0;

        }
    }

    public int totalNQueens(int n) {
        numberOfWays = 0;
        int[][] mat = new int[n][n];
        canWePlaceNQueens(n, mat, 0);
        return numberOfWays;
    }
}