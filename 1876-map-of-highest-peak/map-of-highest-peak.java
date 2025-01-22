/*class Solution {

    int[][]height;
    int m,n;

    private void fillWithZero(int i, int j){
        height[i][j] = 0;
        if(i-1 >= 0) {
            height[i-1][j] = 1;
        }
        if(i+1 < m) {
            height[i+1][j] = 1;
        }
        if(j-1 >= 0) {
            height[i][j-1] = 1;
        }
        if(j+1 < n) {
            height[i][j+1] = 1;
        }
    } 
    private void findWaterCell(int[][]isWater){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j] == 1){
                    fillWithZero(i,j);
                }
            }
        }
    }
    private void fillRemainingHeights(){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(height[i][j] == -1){
                    int minValue = minValueInNeibhourCells(i,j);
                    if(minValue != -1)
                        height[i][j] = minValue+1;
                }
            }
        }
    }
    private int minValueInNeibhourCells(int i,int j){
        int minCell = Integer.MAX_VALUE;
        boolean isAnyCellPresent = false;
        if(i-1 >= 0 && height[i-1][j] != -1) {
            minCell = Math.min(minCell,height[i-1][j]);
            isAnyCellPresent = true;
        }
        if(i+1 < m && height[i+1][j] != -1) {
            minCell = Math.min(minCell,height[i+1][j]);
            isAnyCellPresent = true;
        }
        if(j-1 >= 0 && height[i][j-1] != -1) {
            minCell = Math.min(minCell,height[i][j-1]);
            isAnyCellPresent = true;
        }
        if(j+1 < n && height[i][j+1] != -1) {
            minCell = Math.min(minCell,height[i][j+1]);
            isAnyCellPresent = true;
        }
        return isAnyCellPresent ? minCell : -1;
    }
    public int[][] highestPeak(int[][] isWater) {
        m = isWater.length;
        n = isWater[0].length;
        height = new int[m][n];
        for(int [] h : height){
            Arrays.fill(h,-1);
        }
        findWaterCell(isWater);
        System.out.println(Arrays.deepToString(height));
        fillRemainingHeights();
        fillRemainingHeights();
        return height;
    }
} */



class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int R = isWater.length;
        int C = isWater[0].length;
        int[][] height = new int[R][C];

        // Initialize height array
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0; // Water cell has height 0
                } else {
                    height[i][j] = R + C; // A large value as sentinel
                }
            }
        }

        // First pass: propagate height from top-left to bottom-right
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (height[i][j] != 0) {
                    if (i > 0) 
                        height[i][j] = Math.min(height[i][j], height[i - 1][j] + 1); // Check from top
                    if (j > 0) 
                        height[i][j] = Math.min(height[i][j], height[i][j - 1] + 1); // Check from left
                }
            }
        }

        // Second pass: propagate height from bottom-right to top-left
        for (int i = R - 1; i >= 0; i--) {
            for (int j = C - 1; j >= 0; j--) {
                if (height[i][j] != 0) {
                    if (i < R - 1) 
                        height[i][j] = Math.min(height[i][j], height[i + 1][j] + 1); // Check from bottom
                    if (j < C - 1) 
                        height[i][j] = Math.min(height[i][j], height[i][j + 1] + 1); // Check from right
                }
            }
        }

        return height;
    }
}
