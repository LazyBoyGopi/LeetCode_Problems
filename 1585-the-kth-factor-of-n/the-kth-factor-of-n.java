class Solution {
    public int kthFactor(int n, int k) {
        int countOfFactors = 0;
        for(int i=1;i<=n;i++)
        {
            if(n%i == 0) countOfFactors++;
            if(countOfFactors == k) return i;
        }
        return -1;
    }
}