/*


class Solution {
    int minCost;

    private void checkAllPaths(int[][] grid, int[][] vistedPath, int row, int col, int curCost) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            System.out.println("reached" + " " + curCost);
            minCost = Math.min(minCost, curCost);
            return;
        }
        if (vistedPath[row][col] == -1)
            return;
        vistedPath[row][col] = -1;
        
        int m = grid.length, n = grid[0].length;
        int nextDir = grid[row][col];
        System.out.println(row+" "+col);
        if (col < n - 1) {
            int dir = (nextDir == 1) ? 0 : 1;
            checkAllPaths(grid, vistedPath, row, col + 1, curCost + dir);
        }
        if (row < m - 1){
            int dir = (nextDir == 3) ? 0 : 1;
            checkAllPaths(grid, vistedPath, row + 1, col, curCost + dir);
        }
        if (col > 0){
            int dir = (nextDir == 2) ? 0 : 1;
            checkAllPaths(grid, vistedPath, row, col - 1, curCost + dir);
        }
        if (row > 0){
            int dir = (nextDir == 4) ? 0 : 1;
            checkAllPaths(grid, vistedPath, row - 1, col, curCost + dir);
        }
    }

    public int minCost(int[][] grid) {
        int[][] vistedPath = new int[grid.length][grid[0].length];
        minCost = Integer.MAX_VALUE;
        checkAllPaths(grid, vistedPath, 0, 0, 0);
        return minCost;
    }
}


 

class Solution {
    int minCost;
    private void checkAllPaths(int[][]grid,int[][]vistedPath,int row,int col,int curCost){
        if(vistedPath[row][col] == -1) return;
        vistedPath[row][col] = -1;
        if(row == grid.length-1 && col == grid[0].length-1){
            System.out.println("reached"+" "+curCost);
            minCost = Math.min(minCost,curCost);
            return;
        }
        int m = grid.length, n = grid[0].length;
        int nextDir = grid[row][col];
            System.out.println(nextDir);

        switch(nextDir){
            case 1: {
                if(col < n-1){
                    checkAllPaths(grid,vistedPath,row,col+1,curCost);
                }else{
                    if(row < m-1)
                        checkAllPaths(grid,vistedPath,row+1,col,curCost+1);
                    if(col > 0)
                        checkAllPaths(grid,vistedPath,row,col-1,curCost+1);
                    if(row > 0)
                        checkAllPaths(grid,vistedPath,row-1,col,curCost+1);
                }
            }
            break;
            case 2:{
                if(col > 0){
                    checkAllPaths(grid,vistedPath,row,col-1,curCost);
                }else{
                    if(row < m-1)
                        checkAllPaths(grid,vistedPath,row+1,col,curCost+1);
                    if(col < n-1)
                        checkAllPaths(grid,vistedPath,row,col+1,curCost+1);
                    if(row > 0)
                        checkAllPaths(grid,vistedPath,row-1,col,curCost+1);
                }
            }
            break;
            case 3:{
                if(row < m-1){
                    checkAllPaths(grid,vistedPath,row+1,col,curCost);
                }else{
                    if(col < n-1)
                        checkAllPaths(grid,vistedPath,row,col+1,curCost+1);
                    if(col > 0)
                        checkAllPaths(grid,vistedPath,row,col-1,curCost+1);
                    if(row > 0)
                        checkAllPaths(grid,vistedPath,row-1,col,curCost+1);
                }
            }
            break;
            default:{
                if(row > 0){
                    checkAllPaths(grid,vistedPath,row-1,col,curCost);
                }else{
                    if(row < m-1)
                        checkAllPaths(grid,vistedPath,row+1,col,curCost+1);
                    if(col > 0)
                        checkAllPaths(grid,vistedPath,row,col-1,curCost+1);
                    if(col < n-1)
                        checkAllPaths(grid,vistedPath,row,col+1,curCost+1);
                }
            }
        }
    }
    public int minCost(int[][] grid) {
        int[][] vistedPath = new int[grid.length][grid[0].length];
        minCost = Integer.MAX_VALUE;
        checkAllPaths(grid,vistedPath,0,0,0);
        return minCost;
    }
} 


import java.util.Arrays;

import java.util.Arrays;

class Solution {
    int[][] ans;

    private int checkAllPaths(int[][] grid, int[][] visitedPath, int row, int col) {
        int m = grid.length, n = grid[0].length;

        // If you reach the bottom-right corner, no additional cost needed
        if (row == m - 1 && col == n - 1) {
            return 0;
        }

        // Return already computed result from memoization table if available
        if (ans[row][col] != -1) return ans[row][col];

        // If the cell has been visited in the current path, avoid infinite recursion
        if (visitedPath[row][col] == 1) return Integer.MAX_VALUE;

        // Mark this cell as visited
        visitedPath[row][col] = 1;

        int nextDir = grid[row][col];
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE, top = Integer.MAX_VALUE, down = Integer.MAX_VALUE;

        // Check all four possible directions
        if (col < n - 1) {
            // Move right (1)
            int dir = (nextDir == 1) ? 0 : 1; // no cost if moving right
            right = checkAllPaths(grid, visitedPath, row, col + 1) + dir;
        }
        if (row < m - 1) {
            // Move down (3)
            int dir = (nextDir == 3) ? 0 : 1; // no cost if moving down
            down = checkAllPaths(grid, visitedPath, row + 1, col) + dir;
        }
        if (col > 0) {
            // Move left (2)
            int dir = (nextDir == 2) ? 0 : 1; // no cost if moving left
            left = checkAllPaths(grid, visitedPath, row, col - 1) + dir;
        }
        if (row > 0) {
            // Move up (4)
            int dir = (nextDir == 4) ? 0 : 1; // no cost if moving up
            top = checkAllPaths(grid, visitedPath, row - 1, col) + dir;
        }

        // Unmark the current cell before returning (backtracking)
        visitedPath[row][col] = 0;

        // Memoize the result for this cell
        return ans[row][col] = Math.min(left, Math.min(right, Math.min(top, down)));
    }

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] visitedPath = new int[m][n];
        ans = new int[m][n];

        // Initialize the memoization table with -1 (unvisited state)
        for (int[] ar : ans) {
            Arrays.fill(ar, -1);
        }

        // Start DFS from the top-left corner (0, 0)
        return checkAllPaths(grid, visitedPath, 0, 0);
    }
} */

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Directions: Right, Left, Down, Up
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Cost grid initialization
        int[][] cost = new int[m][n];
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Min-heap: [cost, row, column]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Start from (0, 0) with cost 0
        pq.offer(new int[]{0, 0, 0});
        cost[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currCost = current[0];
            int i = current[1];
            int j = current[2];

            // Early exit if destination is reached
            if (i == m - 1 && j == n - 1) {
                return currCost;
            }

            // Explore all four directions
            for (int dir = 0; dir < 4; dir++) {
                int ni = i + directions[dir][0];
                int nj = j + directions[dir][1];

                // Check boundaries
                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    // If moving in the grid's direction → no extra cost
                    int newCost = (grid[i][j] == dir + 1) ? currCost : currCost + 1;

                    // If this path is cheaper, update and add to the queue
                    if (newCost < cost[ni][nj]) {
                        cost[ni][nj] = newCost;
                        pq.offer(new int[]{newCost, ni, nj});
                    }
                }
            }
        }

        // Return the cost to reach the bottom-right cell
        return cost[m - 1][n - 1];
    }
}