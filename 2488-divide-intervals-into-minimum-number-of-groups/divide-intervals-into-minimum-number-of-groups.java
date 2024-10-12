class Solution {
    public int minGroups(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int maxNumTillNow = (int)10e6;
        List<int[]>nonOverlapingIntervals = new ArrayList();
        nonOverlapingIntervals.add(new int[]{intervals[0][0],intervals[0][1]});
        maxNumTillNow = intervals[0][1];
        for(int i=1;i<len;i++){
            int[] interval = intervals[i];
            if(interval[0] <= maxNumTillNow){
                nonOverlapingIntervals.add(new int[]{interval[0],interval[1]});
            }else{
                boolean isThere = false;
                for(int j=0;j<nonOverlapingIntervals.size();j++){
                    if(nonOverlapingIntervals.get(j)[1] < interval[0]){
                        nonOverlapingIntervals.get(j)[1] = interval[1];
                        isThere = true;
                        break;
                    }
                }
                if(!isThere){
                nonOverlapingIntervals.add(new int[]{interval[0],interval[1]});

                }
                
            }
                maxNumTillNow = Math.min(maxNumTillNow,interval[1]);
            // System.out.println(i);

            //     for(int k=0;k<nonOverlapingIntervals.size();k++){

            // System.out.println(nonOverlapingIntervals.get(k)[0]+" "+nonOverlapingIntervals.get(k)[1]);
            //     }

        }
        // for(int i=0;i<nonOverlapingIntervals.size();i++){
        //     System.out.println(nonOverlapingIntervals.get(i)[0]+" "+nonOverlapingIntervals.get(i)[1]);
        // }
        return nonOverlapingIntervals.size();
    }
}