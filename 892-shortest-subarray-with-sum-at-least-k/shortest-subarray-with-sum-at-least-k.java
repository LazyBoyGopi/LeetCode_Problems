class Solution {
    public static class Pair{
        long val;
        int idx;
        public Pair(long val_,int idx_){
            val = val_;
            idx = idx_;
        }
    } 
    public int shortestSubarray(int[] nums, int k) {
        int len = nums.length, l = 0, r = 0, maxLen = len+1;
        long tSum = 0;
        Queue<Pair>q = new PriorityQueue<>((a,b)->Long.compare(a.val,b.val));
         
        while(r < len){
            tSum += nums[r];
            if(tSum >= k){
                maxLen = Math.min(maxLen,r+1);
            }
            while(!q.isEmpty() && tSum - q.peek().val >= k){
                maxLen = Math.min(maxLen,r-q.poll().idx);
            }
            q.offer(new Pair(tSum,r));
            r++;
        }
        return maxLen == len+1 ? -1 : maxLen; 

        
















        // int len = nums.length, maxLen = len+1;
        // for(int i=0;i<len;i++){
        //     int sum = 0;
        //     for(int j=i;j<len;j++){
        //         sum += nums[j];
        //         if(sum >= k){
        //             maxLen = Math.min(maxLen,j-i+1);
        //             break;
        //         }
        //     }
        // }
        // return maxLen == len+1 ? -1 : maxLen;
    }
}