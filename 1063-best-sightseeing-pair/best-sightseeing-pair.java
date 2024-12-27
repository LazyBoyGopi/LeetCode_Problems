class Solution {


    //Brute force
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


    //Better
    /*
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
    */

    //Optimal
    /*
        int maxTillNow = values[0], len = values.length, maxScore = 0;
        for(int i=1;i<len;i++){
            int ele = values[i];
            if(maxTillNow+ele-i > maxScore) maxScore = maxTillNow+ele-i;
            if(maxTillNow < ele+i) maxTillNow = ele+i;
        }
        return maxScore;
     */

    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;
        int[]maxEle = new int[len];
        maxEle[0] = values[0];
        for(int i=1;i<len;i++){
            maxEle[i] = Math.max(maxEle[i-1],values[i]+i);
        }
        int maxScore = 0;
        for(int i=1;i<len;i++){
            maxScore = Math.max(maxScore,values[i]-i + maxEle[i-1]);
        }
        return maxScore;
    }
}