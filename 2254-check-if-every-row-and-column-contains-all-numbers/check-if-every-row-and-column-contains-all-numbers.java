class Solution {
    private boolean checkRowWise(int[][]matrix){
        int len = matrix.length;
        for(int[] ar : matrix){
            Set<Integer> set = new HashSet<>();
            for(int ele : ar){
                set.add(ele);
            }
            if(set.size() != len) return false;
        }
        return true;
    }
    private boolean checkColWise(int[][]matrix){
        int len = matrix.length;
        for(int i=0;i<matrix.length;i++){
            Set<Integer>set = new HashSet<>();
            for(int j=0;j<matrix.length;j++){
                set.add(matrix[j][i]);
            }
            if(set.size() != len) return false;
        }
        return true;
    }
    public boolean checkValid(int[][] matrix) {
        return checkRowWise(matrix) && checkColWise(matrix);
    }
}