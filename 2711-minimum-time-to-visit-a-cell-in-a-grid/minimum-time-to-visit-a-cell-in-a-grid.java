class Solution {

    /*
    Runtime 200 ms Beats 71.43%
    Memory 52.9 MB Beats 71.43%
     */
    private static final int[][] DIRS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        int[][] distTo = new int[grid.length][grid[0].length];
        for (int[] row : distTo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distTo[0][0] = 0;

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(i -> i[2]));
        queue.add(new int[] {0, 0, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] dir : DIRS) {
                int nextR = curr[0] + dir[0];
                int nextC = curr[1] + dir[1];
                if (nextR >= 0 && nextR < grid.length && nextC >= 0 && nextC < grid[0].length) {
                    int nextDist = curr[2] + 1;
                    if (nextDist < grid[nextR][nextC]) {
                        if (nextDist % 2 == grid[nextR][nextC] % 2) {
                            nextDist = grid[nextR][nextC];
                        } else {
                            nextDist = grid[nextR][nextC] + 1;
                        }
                    }
                    if (distTo[nextR][nextC] > nextDist) {
                        if (nextR == grid.length - 1 && nextC == grid[0].length - 1) {
                            return nextDist;
                        }
                        distTo[nextR][nextC] = nextDist;
                        queue.add(new int[] {nextR, nextC, nextDist});
                    }
                }
            }
        }

        return -1;
    }
}