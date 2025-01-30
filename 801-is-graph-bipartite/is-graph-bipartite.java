class Solution {
    private boolean dfs(int[][]graph,int node,int[]colors){
        Queue<Integer>queue = new ArrayDeque();
        queue.offer(node);
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
        int[]colors = new int[n];
        Arrays.fill(colors,-1);
        colors[0] = 1;
        for(int i=0;i<n;i++){
            if(colors[i] == -1)
                colors[i] = 0;
            if(!dfs(graph,i,colors))
                return false;
        }
        return true;
    }
}