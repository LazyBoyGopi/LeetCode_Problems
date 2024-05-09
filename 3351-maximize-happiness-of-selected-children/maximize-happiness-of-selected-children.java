class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long count = 0;
        Arrays.sort(happiness);
        long ans = 0;
        for(int i=happiness.length-1;i>=0 && k>0;i--)
        {
            ans = ans + ((happiness[i] - count) >= 0 ? happiness[i] - count : 0);
            k--;
            count++;
        }
        return ans;
    }
}