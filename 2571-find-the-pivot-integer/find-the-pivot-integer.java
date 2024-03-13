class Solution {
    public int pivotInteger(int n) {
        // if (n==1) return n;
        int sum = 0;
        for(int i=1;i<=n;i++)
        {
            sum += i;
        }
        int preSum = 0;
        for(int i=1;i<=n;i++)
        {
            preSum += i;
            if(preSum == sum-preSum+i) return i;
        }
        return -1;
    }
}