class Solution {
    private int getHours(int[]piles,int numberOfBananas)
    {
        int hours = 0;
        for(int ele : piles)
        {
            hours += Math.ceil(ele*1.0/numberOfBananas*1.0);
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1 , high = Integer.MAX_VALUE , ans = 0;
        while(low <= high)
        {
            int mid = low+(high-low)/2;
            int hours = getHours(piles,mid);
            if(hours <= h)
            {
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
}