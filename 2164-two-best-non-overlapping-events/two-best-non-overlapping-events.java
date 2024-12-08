class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        int []suffix = new int[n];
        int maxSum = Integer.MIN_VALUE;
        Arrays.sort(events,(a,b)-> a[0]-b[0]);
        suffix[n-1] = events[n-1][2];
        for(int i=n-2;i>=0;--i){
            suffix[i] = Math.max(suffix[i+1],events[i][2]);
        }
        for(int i=0;i<n;i++){
            int curEndTime = events[i][1];
            int l = i+1,r = n-1;
            int nextEventIdx = -1;
            while(l <= r){
                int mid = l+(r-l)/2;
                if(events[mid][0] > curEndTime){
                    nextEventIdx = mid;
                    r = mid-1;
                }
                else l = mid+1;
            }
            if(nextEventIdx != -1){
                maxSum = Math.max(maxSum,events[i][2]+suffix[nextEventIdx]);
            }
            maxSum = Math.max(maxSum,events[i][2]);
        }
        return maxSum;
    }
}