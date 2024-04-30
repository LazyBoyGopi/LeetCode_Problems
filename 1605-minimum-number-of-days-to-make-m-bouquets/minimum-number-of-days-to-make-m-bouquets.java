class Solution {
    private int findMax(int[]bloomDay)
    {
        int max = Integer.MIN_VALUE;
        for(int ele : bloomDay)
        {
            max = Math.max(ele,max);
        }
        return max;
    }
    private boolean isPossible(int[]bloomDay,int days,int bouquets,int numberOfFlowers)
    {
        int count = 0;
        for(int ele : bloomDay)
        {
            if(count >= numberOfFlowers)
            {
                bouquets--;
                count = 0;
            }
            if(ele - days <= 0)
            {
                count++;
            }
            else{
                count = 0;
            }
            if(bouquets <= 0) return true;
        }
        if(count >= numberOfFlowers) bouquets--;
        return bouquets <= 0;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < (m*k)) return -1;
        int low = 0 , high = findMax(bloomDay);
        int ans = -1;
        while(low <= high)
        {
            int mid = low+(high-low)/2;
            if(isPossible(bloomDay,mid,m,k))
            {
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
}