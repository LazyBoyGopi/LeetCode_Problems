class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> merged = new LinkedList<>();
        int[] curInterval = intervals[0];
        for(int curIdx = 0 ;curIdx < intervals.length;curIdx++)
        {
            if(curInterval[1] >= intervals[curIdx][0])
            {
                curInterval[1] = Math.max(curInterval[1],intervals[curIdx][1]);
            }
            else{
                merged.add(curInterval);
                curInterval = intervals[curIdx];
            }

        }
        merged.add(curInterval);
        return merged.toArray(new int[merged.size()][]);
    }
}