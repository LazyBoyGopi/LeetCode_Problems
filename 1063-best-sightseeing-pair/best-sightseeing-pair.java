class Solution {

    /*
    int maxScore = Integer.MIN_VALUE;
        int len = values.length;
        System.out.println(len);
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                int curScore = values[i]+values[j] + i-j;
                maxScore = Math.max(curScore,maxScore);
            }
        }
        return maxScore;
    */

    /*private class Pair{
        int val;
        int idx;
        public Pair(int val,int idx){
            this.val = val;
            this.idx = idx;
        }
    Queue<Pair>queue = new PriorityQueue<Pair>((a,b) ->b.val-a.val);
        for(int i=0;i<values.length;i++){
            queue.offer(new Pair(values[i],i));
        }
        int maxScore = 0;
        Pair maxElePair = queue.poll();
        int maxEle = maxElePair.val, maxIdx = maxElePair.idx;
        for(Pair pair : queue){
            int curScore = maxEle + pair.val - Math.abs(maxIdx-pair.idx); 
            maxScore = Math.max(maxScore,curScore);
        }
        return maxScore;
    }
    */
    public int maxScoreSightseeingPair(int[] values) {

        int maxTillNow = values[0];
        int ans = Integer.MIN_VALUE;
        int len = values.length;
        for(int i=1;i<len;i++){
            int ele = values[i];
            ans = Math.max(ans,maxTillNow+ele-i);
            maxTillNow = Math.max(maxTillNow,ele+i);
        }
        return ans;
    }
}