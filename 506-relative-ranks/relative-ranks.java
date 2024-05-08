class Solution {
    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
       int[]copy = new int[len];
       String[]ans = new String[len];
       for(int i=0;i<len;i++)
       {
        copy[i] = score[i];
       } 
       Arrays.sort(copy);
        for(int i=len-1;i>=0;i--)
        {
            int j;
            for(j=0;j<len;j++)
            {
                if(copy[i] == score[j]) break;
            }
            if(i == len-1) ans[j] = "Gold Medal";
            else if(i == len-2) ans[j] = "Silver Medal";
            else if(i == len-3) ans[j] = "Bronze Medal";
            else{
                ans[j] = Integer.toString((len-i));
            }
        }
        return ans;
    }
}