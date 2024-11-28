class Solution {
    int[][]directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][]minObstacles = new int[m][n];
        for(int []obstacle : minObstacles){
            Arrays.fill(obstacle,Integer.MAX_VALUE);
        }
        Queue<int[]>pq = new PriorityQueue<int[]>((a,b)-> Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0,0,0});
        minObstacles[0][0] = 0;
        while(!pq.isEmpty()){
            int[]cur = pq.poll();
            int obstacles = cur[0], row = cur[1], col = cur[2];
            if(row == m-1 && col == n-1) return obstacles;
            for(int[]dir : directions){
                int newRow = row+dir[0], newCol = col+dir[1];
                if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n){
                    int newObstacles = obstacles + grid[newRow][newCol];
                    if(minObstacles[newRow][newCol] == Integer.MAX_VALUE){
                        minObstacles[newRow][newCol] = newObstacles;
                        pq.offer(new int[]{newObstacles,newRow,newCol});
                    }
                }
            }
        }
        return -1;
    }
}