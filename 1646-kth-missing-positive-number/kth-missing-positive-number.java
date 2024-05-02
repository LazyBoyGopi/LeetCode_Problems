class Solution {
    public int findKthPositive(int[] arr, int k) {
        int st = 0 , end = arr.length-1;
        while(st <= end)
        {
            int mid = st+(end-st)/2;
            int missing = arr[mid]-(mid+1);
            if(missing >= k)
            {
                end = mid-1;
            }
            else st = mid+1;
        }
        return k+st;
    }
}