class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        if(k % mat[0].length == 0) return true;
        k %= mat[0].length;
        for(int i=0;i<mat.length;i++){
            int[]dup = new int[mat[0].length];
            int j ,idx = 0;
            for(j=k;j<mat[0].length;j++){
                dup[idx++] = mat[i][j];
            }
            for(j=0;j<k;j++){
                dup[idx++] = mat[i][j];
            }
            for(j=0;j<mat[0].length;j++){
                if(mat[i][j] != dup[j]) return false;
            }
        }
        return true;
    }
}