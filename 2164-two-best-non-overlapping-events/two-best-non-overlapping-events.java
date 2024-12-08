class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        int maxSum = Integer.MIN_VALUE;
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        int[]suffix = new int[n];
        suffix[n-1] = events[n-1][2];
        for(int i=n-2;i>=0;i--){
            suffix[i] = Math.max(suffix[i+1],events[i][2]);
        }
        for(int i=0;i<n;i++){
            int curEndTime = events[i][1];
            int st = i, end = n-1;
            int nextEventIdx = -1;
            while(st <= end){
                int mid = st+(end-st)/2;
                if(events[mid][0] > curEndTime) {
                    nextEventIdx = mid;
                    end = mid-1;
                }
                else st = mid+1;
            }

            if(nextEventIdx != -1){
                maxSum = Math.max(maxSum,events[i][2]+suffix[nextEventIdx]);
            }
            maxSum = Math.max(maxSum,events[i][2]);
        }
        return maxSum;
    }
}