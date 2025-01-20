/**

class Solution {
    private boolean isFullyFilled(int row,int col,int[][]mat){
        int m = mat.length, n = mat[0].length;
        boolean isFilled = true;
        for(int i=0;i<m;i++){
            if(mat[i][col] != -1){
                isFilled = false;
                break;
            }
        }
        if(isFilled) return true;
        isFilled = true;
        for(int i=0;i<n;i++){
            if(mat[row][i] != -1){
                isFilled = false;
                break;
            }
        }
        return isFilled;
    }
    private boolean paintCurValue(int[][]mat,int cellValue){
        int m = mat.length, n = mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == cellValue){
                    mat[i][j] = -1;
                    return isFullyFilled(i,j,mat);
                }
            }
        }
        return false;
    }
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int arrLength = arr.length;
        for(int i=0;i<arrLength;i++){
            boolean isRowOrColFilled = paintCurValue(mat,arr[i]);
            // System.out.println(Arrays.deepToString(mat));
            // System.out.println(isRowOrColFilled+" "+i);
            if(isRowOrColFilled) return i;
        }
        return -1;
    }
}

**/


class Solution {
    private int[][] convertToMap(int[][]mat){
        int m = mat.length, n = mat[0].length;
        int[][]map = new int[(m*n)+1][2];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map[mat[i][j]] = new int[]{i,j};
            }
        }
        return map;
    }
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int arrLength = arr.length, m = mat.length, n = mat[0].length;

        int[][]map = convertToMap(mat);

        int[]rows = new int[m];
        int[]cols = new int[n];

        for(int i=0;i<arrLength;i++){
            int[]indexes = map[arr[i]];
            mat[indexes[0]][indexes[1]] = -1;
            int col = ++rows[indexes[0]];
            int row = ++cols[indexes[1]];
            if(col == n || row == m) return i;
        }
        return -1;
    }
}