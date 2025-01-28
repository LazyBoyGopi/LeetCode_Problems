/**


class Solution {
    int max = 0;
    int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
    private void getMax(int i,int j,int[][]grid,Set<int[]>set,int cur){
        max = Math.max(max,cur);
        int m = grid.length, n = grid[0].length;
        if(i < 0 || j <0 || i >=m  || j >= n) return;
        int[]cell = {i,j};
        if(grid[i][j] == 0 || set.contains(cell)) return;
        set.add(cell);
        int cellVal = grid[i][j];
        grid[i][j] = 0;
        for(int []d : dir){
            int r = i+d[0], c = j+d[1];
            getMax(r,c,grid,set,cur+cellVal);
        }
        grid[i][j] = cellVal;
        set.remove(cell);
    }
    public int findMaxFish(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                getMax(i,j,grid,new HashSet(),0);
            }
        }
        return max;
    }
} */

class Solution {
    int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};

    boolean[][]visted;
    private int getMax(int i,int j,int[][]grid){
        int m = grid.length, n = grid[0].length;

        if(i < 0 || j < 0 || i >= m  || j >= n || grid[i][j] == 0 || visted[i][j]) return 0;
        visted[i][j] = true;
        
        int curMax = grid[i][j];
        for(int []d : dir){
            int r = i+d[0], c = j+d[1];
            curMax += getMax(r,c,grid);
        }

        return curMax;
    }
    public int findMaxFish(int[][] grid) {
        int m = grid.length, n = grid[0].length, max = 0;
        visted = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] != 0 && !visted[i][j])
                    max = Math.max(max,getMax(i,j,grid));
            }
        }
        return max;
    }
}