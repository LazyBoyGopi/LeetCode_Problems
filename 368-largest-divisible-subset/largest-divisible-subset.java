class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length, maxIdx = 0, totalMaxEle = 0;
        List<Integer>[] dp = new ArrayList[len];
        for (int i = len - 1; i >= 0; i--) {
            int maxElements = 1;
            int idx = i;
            dp[idx] = new ArrayList();
            for (int j = i + 1; j < len; j++) {
                if (nums[j] % nums[i] == 0) {
                    if (maxElements <= dp[j].size()) {
                        idx = j;
                        maxElements = dp[j].size();
                    }
                }
            }
            dp[i].add(nums[i]);
            if (i != idx) {
                dp[i].addAll(dp[idx]);
            }
            if(totalMaxEle < dp[i].size()){
                totalMaxEle = dp[i].size();
                maxIdx = i;
            }
        }
        
        return dp[maxIdx];
    }
}