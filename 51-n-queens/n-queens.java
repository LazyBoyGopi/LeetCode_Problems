class Solution {
    private void canWePlaceNQueens(int n, int[][] mat, int curRow,List<List<String>> list,List<String>tempList ) {
        if (curRow == n) {
            list.add(new LinkedList(tempList));
            return;
        }
        outer : for (int j = 0; j < n; j++) {

            int curCol = j;

            for (int i = 0; i < n; i++) {
                if (mat[curRow][i] == 1)
                    continue outer;
            }

            for (int i = 0; i < n; i++) {
                if (mat[i][curCol] == 1)
                     continue outer;
            }

            for(int r=curRow,c=curCol; r>=0 && c>=0; r--,c--){
                if(mat[r][c] == 1) continue outer;
            }


            for(int r=curRow,c=curCol; r<n && c>=0; r++,c--){
                if(mat[r][c] == 1) continue outer;
            }

            for(int r=curRow,c=curCol; r>=0 && c<n; r--,c++){
                if(mat[r][c] == 1) continue outer;
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                if(i == curCol) sb.append('Q');
                else sb.append('.');
            }

            mat[curRow][curCol] = 1;
            tempList.add(sb.toString());
            canWePlaceNQueens(n, mat, curRow + 1,list,tempList);
            tempList.remove(tempList.size()-1);
            mat[curRow][curCol] = 0;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new LinkedList();
        int[][] mat = new int[n][n];
        canWePlaceNQueens(n, mat, 0,list,new LinkedList());
        return list;
    }
}