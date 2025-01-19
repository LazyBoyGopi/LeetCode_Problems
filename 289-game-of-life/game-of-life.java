/*
class Solution {
    private int getNeighborsAliveCells(int row,int col,int[][]board){
        int aliveCells = 0,m = board.length, n = board[0].length;
        if(row-1 >=0 && col-1 >= 0 && board[row-1][col-1] == 1) aliveCells++;
        if(row-1 >=0 && board[row-1][col] == 1) aliveCells++;

        if(row-1 >=0 && col+1 < n && board[row-1][col+1] == 1) aliveCells++;
        if(col-1 >= 0 && board[row][col-1] == 1) aliveCells++;

        if(col+1 < n && board[row][col+1] == 1) aliveCells++;
        if(row+1 < m && col-1 >=0 && board[row+1][col-1] == 1) aliveCells++;

        if(row+1 < m && board[row+1][col] == 1) aliveCells++;
        if(row+1 < m && col+1 < n && board[row+1][col+1] == 1) aliveCells++;
        return aliveCells;
    }
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][]ans = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){ 
                int aliveCells = getNeighborsAliveCells(i,j,board);
                if(board[i][j] == 1){
                    // if(aliveCells < 2){
                    //     ans[i][j] = 0;
                    // }
                    if(aliveCells == 2 || aliveCells == 3){
                        ans[i][j] = 1;
                    }
                    // if(aliveCells > 3){
                    //     ans[i][j] = 0;
                    // }
                }else {
                    if(aliveCells == 3){
                        ans[i][j] = 1;
                    }
                }
            }
        }
        copyArray(ans,board);
    }
    private void copyArray(int[][]ans,int[][]board){
        int m = board.length, n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j] = ans[i][j];
            }
        }
    }
}
 */



class Solution {
    private int getNeighborsAliveCells(int row,int col,int[][]board){
        int aliveCells = 0,m = board.length, n = board[0].length;
        if(row-1 >=0 && col-1 >= 0){
            int curVal = board[row-1][col-1];
            if(curVal == 1 || curVal == 2 || curVal == 3)
                aliveCells++;
        } 
        if(row-1 >=0) {
            int curVal = board[row-1][col];
            if(curVal == 1 || curVal == 2 || curVal == 3)
                aliveCells++;
        }

        if(row-1 >=0 && col+1 < n) {
            int curVal = board[row-1][col+1];
            if(curVal == 1 || curVal == 2 || curVal == 3)
                aliveCells++;
        }
        if(col-1 >= 0) {
            int curVal = board[row][col-1];
            if(curVal == 1 || curVal == 2 || curVal == 3)
                aliveCells++;
        }

        if(col+1 < n){
            int curVal = board[row][col+1];
            if(curVal == 1 || curVal == 2 || curVal == 3)
                aliveCells++;
        }
        if(row+1 < m && col-1 >=0){
            int curVal = board[row+1][col-1];
            if(curVal == 1 || curVal == 2 || curVal == 3)
                aliveCells++;
        }

        if(row+1 < m){
            int curVal = board[row+1][col];
            if(curVal == 1 || curVal == 2 || curVal == 3)
                aliveCells++;
        }
        if(row+1 < m && col+1 < n){
            int curVal = board[row+1][col+1];
            if(curVal == 1 || curVal == 2 || curVal == 3)
                aliveCells++;
        }
        return aliveCells;
    }
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){ 
                int aliveCells = getNeighborsAliveCells(i,j,board);
                if(board[i][j] == 1){
                    if(aliveCells < 2 || aliveCells > 3){
                        board[i][j] = 3;
                    }
                    else if(aliveCells == 2 || aliveCells == 3){
                        board[i][j] = 2;
                    }
                }else if(aliveCells == 3){
                    board[i][j] = 4;
                }
            }
        }
        copyArray(board);
    }
    private void copyArray(int[][]board){
        int m = board.length, n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int curVal = board[i][j];
                if(curVal == 2 || curVal == 4) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }
    }
}