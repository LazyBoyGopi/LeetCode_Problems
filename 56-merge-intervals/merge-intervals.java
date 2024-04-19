class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<List<Integer>> list = new LinkedList<>();
        for(int i=0;i<intervals.length;i++)
        {
            if(list.isEmpty() || list.get(list.size()-1).get(1) < intervals[i][1])
            {
                List<Integer>temp = new LinkedList<>(Arrays.asList(intervals[i][0],intervals[i][1]));
                list.add(temp);
            }
            int ele = list.get(list.size()-1).get(1);
            for(int j=i;j<intervals.length;j++)
            {
                if(ele >= intervals[j][0])
                {
                    if(ele < intervals[j][1])
                    {
                    list.get(list.size()-1).set(1,intervals[j][1]);
                    ele = intervals[j][1];
                    }
                }
                else {
                    i=j-1;
                    break;
                }
            }
        }
        int[][]ans = new int[list.size()][2];
        for(int i=0;i<list.size();i++)
        {
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }
}