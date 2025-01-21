/**

class Solution {
    long maxSum = -1l;
    int[][]path;
    private void getHighestScoringPath(int[][]grid,long sum,int r,int c,int[][]curPath,int idx){
        int m = 2, n = grid[0].length;
        sum += grid[r][c];
        curPath[idx] = new int[]{r,c};
        if(r == m-1 && c == n-1){
            if(sum > maxSum){
                maxSum = sum;
                int[][]newPath = new int[n+1][2];
                for(int i=0;i<n+1;i++){
                    newPath[i][0] = curPath[i][0];
                    newPath[i][1] = curPath[i][1];
                }
                path = newPath;
            }
            return;
        }
        if(c < n-1){
            getHighestScoringPath(grid,sum,r,c+1,curPath,idx+1);
        }
        if(r < m-1){
            getHighestScoringPath(grid,sum,r+1,c,curPath,idx+1);
        }
    }
    private long totalSum(int[][]grid){
        int n = grid[0].length;
        long tSum = 0l;
        for(int i=0;i<n;i++){
            tSum += grid[0][i];
            tSum += grid[1][i];
        }
        return tSum;
    }
    private void changeTheHighestPath(int[][]grid){
        int pathLen = path.length;
        for(int i=0;i<pathLen;i++){
            grid[path[i][0]][path[i][1]] = 0;
        }
    }
    public long gridGame(int[][] grid) {
        long sum = 0l;
        int n = grid[0].length;
        path = new int[n+1][2];
        getHighestScoringPath(grid,sum,0,0,new int[n+1][2],0);
        changeTheHighestPath(grid);
        maxSum = 0;
        getHighestScoringPath(grid,sum,0,0,new int[n+1][2],0);
        return maxSum;
    }
}


class Solution {
    long minSum;
    int[][]path;
    long tSum;
    long maxSum;
    private void getHighestScoringPath(int[][]grid,long sum,int r,int c,int[][]curPath,int idx){
        int m = 2, n = grid[0].length;
        sum += grid[r][c];
        curPath[idx] = new int[]{r,c};
        if(r == m-1 && c == n-1){
            long diff = tSum-sum;
            if(diff < minSum){
                minSum = diff;
                int[][]newPath = new int[n+1][2];
                for(int i=0;i<n+1;i++){
                    newPath[i][0] = curPath[i][0];
                    newPath[i][1] = curPath[i][1];
                }
                path = newPath;
            }
            if(sum > maxSum){
                maxSum = sum;
            }
            return;
        }
        if(c < n-1){
            getHighestScoringPath(grid,sum,r,c+1,curPath,idx+1);
        }
        if(r < m-1){
            getHighestScoringPath(grid,sum,r+1,c,curPath,idx+1);
        }
    }
    private void totalSum(int[][]grid){
        int n = grid[0].length;
        tSum = 0l;
        for(int i=0;i<n;i++){
            tSum += grid[0][i];
            tSum += grid[1][i];
        }
    }
    private void changeTheHighestPath(int[][]grid){
        int pathLen = path.length;
        for(int i=0;i<pathLen;i++){
            grid[path[i][0]][path[i][1]] = 0;
        }
    }
    public long gridGame(int[][] grid) {
        long sum = 0l;
        int n = grid[0].length;
        path = new int[n+1][2];
        totalSum(grid);
        minSum = tSum;
        getHighestScoringPath(grid,sum,0,0,new int[n+1][2],0);
        changeTheHighestPath(grid);
        maxSum = 0;
        getHighestScoringPath(grid,sum,0,0,new int[n+1][2],0);
        return maxSum;
    }
}

class Solution {
    private int[][] getSuffixSum(int[][]grid){
        int n = grid[0].length;
        int[][]sufSum = new int[2][n];
        sufSum[0][n-1] = grid[0][n-1]+grid[1][n-1];
        sufSum[1][n-1] = grid[1][n-1];
        for(int i=n-2;i>=0;i--){
            sufSum[0][i] = grid[0][i] + sufSum[0][i+1];
            sufSum[1][i] = grid[1][i] + sufSum[1][i+1];
        }
        return sufSum;
    }
    private long getSum(int[][]sufSum,int[][]grid){
        int n = sufSum[0].length;
        long sum = 0;
        boolean addedFinal = false;
        for(int i=0;i<n;i++){
            sum += grid[0][i];
            grid[0][i] = 0;
            if(i+1 < n && sufSum[1][i] > sufSum[0][i+1]){
                sum += sufSum[1][i];
                addedFinal = true;
                while(i < n){
                    grid[1][i++] = 0;
                }
                break;
            }
        }
        if(!addedFinal){
            sum += grid[1][n-1];
            grid[1][n-1] = 0;
        }
        return sum;
    }
    public long gridGame(int[][] grid) {
        getSuffixSum(grid);
        getSum(sufSum,grid);
        sufSum = getSuffixSum(grid);
        return getSum(sufSum,grid);
    }
}

**/

class Solution {
    private long totalSum(int[][]grid){
        int n = grid[0].length;
        long sum = 0l;
        for(int i=0;i<n;i++){
            sum += grid[0][i];
        }
        return sum;
    }
    public long gridGame(int[][] grid) {
        long tSum = totalSum(grid), ps1 = 0l, ps2 = 0l;
        int n = grid[0].length;
        long maxSum = Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            ps1 += grid[0][i];
            long rightHalf = tSum - ps1;
            long leftHalf = ps2;
            ps2 += grid[1][i];
            maxSum = Math.min(maxSum,Math.max(rightHalf,leftHalf));
        }
        return maxSum;   
    }
}