class Solution {
    boolean isVisted[];
    private boolean dfs(int[][]graph,int node,int[]colors){
        int[] edge = graph[node];
        Queue<Integer>queue = new ArrayDeque();
        int clr = colors[node] = colors[node] == -1 ? 1 : colors[node];
        for(int ele : edge){
            queue.offer(ele);
            if(colors[ele] == -1)
                colors[ele] = 1-clr;
            else if(colors[ele] == clr)
                return false;
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int color = colors[cur];
            for(int curNode : graph[cur]){
                if(colors[curNode] == -1){
                    queue.offer(curNode);
                    colors[curNode] = 1-color;
                }else if(colors[curNode] == color)
                    return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        isVisted = new boolean[n];
        int[]colors = new int[n];
        Arrays.fill(colors,-1);
        colors[0] = 1;
        for(int i=0;i<n;i++){
            if(isVisted[i]) continue;
            if(!dfs(graph,i,colors))
                return false;
        }
        return true;
    }
}