class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]>mergedList = new ArrayList();
        int last = intervals[0][1], len = intervals.length;

        mergedList.add(new int[]{intervals[0][0],intervals[0][1]});
        for(int i=1;i<len;i++){
            int[]interval = intervals[i];
            int st = interval[0];
            int end = interval[1];
            if(st <= last){
                int mSize = mergedList.size();
                int preLast = mergedList.get(mSize-1)[1];
                mergedList.get(mSize-1)[1] = last = Math.max(preLast,end);
            }else{
                mergedList.add(new int[]{st,end});
                last = end;
            }
        }
        int[][]ans = new int[mergedList.size()][2];
        int idx = 0;
        for(int []ar: mergedList){
            ans[idx][0] = ar[0];
            ans[idx++][1] = ar[1];
        }
        return ans;
    }
}