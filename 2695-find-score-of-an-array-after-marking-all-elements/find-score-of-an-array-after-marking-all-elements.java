class Solution {
    public long findScore(int[] nums) {
        long score = 0l;
        int len = nums.length;
        boolean [] checkedIndexes = new boolean[len+2];
        Queue<int[]>queue = new PriorityQueue<int[]>((a,b)->{
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0] - b[0];
        });
        for(int i=0;i<len;i++){
            int[] pair = new int[]{nums[i],i};
            queue.offer(pair);
        }
        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int idx = pair[1];
            if(checkedIndexes[idx]) continue;
            score += pair[0];
            checkedIndexes[idx+1] = true;
            if(idx != 0)
            checkedIndexes[idx-1] = true;
        }
        return score;
    }
}