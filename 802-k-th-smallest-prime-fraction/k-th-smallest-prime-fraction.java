class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        int idx = 0;
        double[]ar = new double[n*(n-1)/2];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                ar[idx++] = (arr[i]*1.0)/(arr[j]*1.0);
            }
        }
        Arrays.sort(ar);
        double ans = ar[k-1];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(ans == (arr[i]*1.0)/(arr[j]*1.0)){
                    return new int[]{arr[i],arr[j]};
                }
            }
        }
        return new int[]{};
    }
}