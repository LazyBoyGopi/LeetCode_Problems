class Solution {
    private int getSum(int[]weights)
    {
        int sum = 0;
        for(int weight  :weights) sum += weight;
        return sum;
    }
    private boolean isPossible(int[]weights,int capacity,int days)
    {
        int weight = 0;
        for(int ele : weights)
        {
            if(ele > capacity) return false;
            if(weight + ele <= capacity) weight += ele;
            else{
                days--;
                weight = ele;
            }
        }
        return days > 0;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 1 , high = getSum(weights);
        while(low <= high)
        {
            int mid = low+(high-low)/2;
            if(isPossible(weights,mid,days)) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}