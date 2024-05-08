class Solution {
    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        String[]ans = new String[len];
        int max = Integer.MAX_VALUE;
        int count = 0;
        for(int i=0;i<len;i++)
        {
            int curMax = Integer.MIN_VALUE;
            int idx = -1;
            count++;
            for(int j=0;j<len;j++)
            {
                if(score[j] < max)
                {
                   if(curMax < score[j]){
                    curMax = score[j];
                    idx = j;
                   }
                }
            }
            if(count == 1){
                ans[idx] = "Gold Medal";
            }
            else if(count == 2)
            {
                ans[idx] = "Silver Medal";
            }
            else if(count == 3)
            {
                ans[idx] = "Bronze Medal";
            }
            else{
                ans[idx] = Integer.toString(count);
            }
            max = curMax;
        }
        return ans;
    }
}