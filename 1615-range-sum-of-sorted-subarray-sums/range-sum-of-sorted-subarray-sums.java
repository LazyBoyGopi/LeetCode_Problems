class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] ar = new int[(n*(n+1))/2];
        int idx = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum += nums[j];
                ar[idx++] = sum;
            }
        }
        Arrays.sort(ar);
        long sum = 0;
        int MOD = 1_000_000_007;
        for(int i=left;i<=right;i++){
            sum += ar[i-1];
           sum %= MOD;
        }
        return (int)(sum%MOD);
    }
}