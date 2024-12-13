class Solution {
    private class Pair{
        public int value;
        public int index;
        public Pair(int _value,int _index){
            value = _value;
            index = _index;
        }
    }
    public long findScore(int[] nums) {
        long score = 0l;
        Set<Integer>checkedIndexes = new HashSet();
        Queue<Pair>queue = new PriorityQueue<Pair>((a,b)->{
            if(a.value == b.value) return a.index-b.index;
            return a.value - b.value;
        });
        for(int i=0;i<nums.length;i++){
            Pair pair = new Pair(nums[i],i);
            queue.offer(pair);
        }
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int idx = pair.index;
            if(checkedIndexes.contains(idx)) continue;
            score += pair.value;
            checkedIndexes.add(idx+1);
            checkedIndexes.add(idx-1);
        }
        return score;
    }
}