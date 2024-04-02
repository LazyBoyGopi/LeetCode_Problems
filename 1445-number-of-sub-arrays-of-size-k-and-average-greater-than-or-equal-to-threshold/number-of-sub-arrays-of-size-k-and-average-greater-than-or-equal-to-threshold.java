class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int low = 0 , high = 0;
        int sum = 0 , count = 0;
        while(high < arr.length)
        {
            sum += arr[high];
            if(high - low+1 == k)
            {
                if(sum / k >= threshold) count++;
                sum -= arr[low++];
            }
            high++;
        }
        return count;
    }
}