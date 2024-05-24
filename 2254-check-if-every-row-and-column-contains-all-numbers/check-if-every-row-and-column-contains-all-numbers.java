class Solution {
    private boolean checkRowWise(int[][]matrix){
        int len = matrix.length;
        for(int[] ar : matrix){
            Set<Integer> set = new HashSet<>();
            for(int ele : ar){
                if(set.contains(ele)) return false;
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
                int num = matrix[j][i];
                if(set.contains(num)) return false;
                set.add(num);
            }
            if(set.size() != len) return false;
        }
        return true;
    }
    public boolean checkValid(int[][] matrix) {
        return checkRowWise(matrix) && checkColWise(matrix);
    }
}