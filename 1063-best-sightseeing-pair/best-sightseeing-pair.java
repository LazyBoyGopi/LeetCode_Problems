class Solution {

    /*
    int maxScore = Integer.MIN_VALUE;
        int len = values.length;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                int curScore = values[i]+values[j] + i-j;
                maxScore = Math.max(curScore,maxScore);
            }
        }
        return maxScore;
    */

    /*
        Queue<Integer>queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        int maxScore = 0,len = values.length;
        queue.offer(values[0]);
        for(int i=0;i<len;i++){
            int ele = values[i];
            int top = queue.peek();
            if(top + ele-i > maxScore) maxScore = top+ele-i;
            queue.offer(ele+i);
        }
        return maxScore;
    }
    */
    public int maxScoreSightseeingPair(int[] values) {
        Queue<Integer>queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        int maxScore = 0,len = values.length;
        queue.offer(values[0]);
        for(int i=1;i<len;i++){
            int ele = values[i];
            int top = queue.peek();
            if(top + ele-i > maxScore) maxScore = top+ele-i;
            queue.offer(ele+i);
        }
        return maxScore;
    }
}