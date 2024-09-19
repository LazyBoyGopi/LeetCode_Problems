class Solution {
    public int minimumSum(int n, int k) {
        if(n+n-1 < k || k ==1 || k==2) return (n*(n+1))/2;
        int half = k/2;
        int firstHalf = (half*(half+1))/2;
        int i = k , j = k + (n-half-1);
        int secondHalf = ((i+j) * (j-i+1))/2;
        return firstHalf + secondHalf;
    }
}