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
        // return tSum;
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
        System.out.println(minSum);
        maxSum = 0;
        getHighestScoringPath(grid,sum,0,0,new int[n+1][2],0);
        return maxSum;
    }
}



class Solution {
    long maxSum,tSum;
    int[][]path;
    private void getHighestScoringPath(int[][]grid,long sum,int r,int c,int[][]curPath,int idx){
        System.out.println(r+" "+c);
        int m = 2, n = grid[0].length;
        sum += grid[r][c];
        curPath[idx] = new int[]{r,c};
        if(r == m-1 && c == n-1){
            System.out.println("Reached "+sum);
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
        tSum = 0l;
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
        totalSum(grid);
        getHighestScoringPath(grid,sum,0,0,new int[n+1][2],0);
        changeTheHighestPath(grid);
        maxSum = 0;
        getHighestScoringPath(grid,sum,0,0,new int[n+1][2],0);
        return maxSum;
    }
}

**/

class Solution {
    private long getSufSum(int[][]grid){
        long sum = 0l;
        for(int ele : grid[0]) sum += ele;
        return sum;
    }
    public long gridGame(int[][] grid) {
        long firstSum = getSufSum(grid), maxSum = Long.MAX_VALUE, secondHalf = 0l;
        int n = grid[0].length;
        for(int i=0;i<n;i++){
            firstSum -= grid[0][i];
            maxSum = Math.min(maxSum,Math.max(firstSum,secondHalf));
            secondHalf += grid[1][i];
        }
        return maxSum;
    }
}