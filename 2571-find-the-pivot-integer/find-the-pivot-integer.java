class Solution {
    public int pivotInteger(int n) {
        int sum = (n*(n+1))/2;
        int st = 0 , end = n;
        while(st <= end)
        {
            int mid = st+(end-st)/2;
            int leftSum = (mid*(mid+1))/2;
            int diff = sum-leftSum+mid ;
            if(diff == leftSum) return mid;
            if(diff < leftSum) end = mid-1;
            else st = mid+1;
        }
        return -1;
    }
}