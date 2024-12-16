class Solution {
    private class Pair{
        public int value;
        public int index;
        public Pair(int _value,int _index){
            value = _value;
            index = _index;
        }
    }

    /**
    Method - 1
    int len = nums.length;
        Queue<Pair>queue = new PriorityQueue<>((a,b)->{
            if(a.value==b.value) return a.index-b.index;
            return a.value-b.value;
        });
        for(int i=0;i<len;i++){
            queue.offer(new Pair(nums[i],i));
        }
        while(k > 0){
            Pair curPair = queue.poll();
            int newValue = curPair.value*multiplier;
            queue.offer(new Pair(newValue,curPair.index));
            k--;
        }
        for(Pair pair : queue){
            nums[pair.index] = pair.value;
        }
        return nums;
     */
    private int getMin(int[]nums){
        int minIdx = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] < nums[minIdx]) minIdx = i;
        }
        return minIdx;
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k > 0){
            int minIdx = getMin(nums);
            nums[minIdx] *= multiplier;
            k--;
        }
        return nums;
    }
}