class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<Integer>[] dp = new ArrayList[len];
        System.out.println(Arrays.toString(nums));
        for(int i=len-1;i>=0;i--){
            int maxElements = 1;
            int idx = i;
            dp[idx] = new ArrayList();
            for(int j=i+1;j<len;j++){
                if(nums[j] % nums[i] == 0){
                    if(maxElements <= dp[j].size()){
                        idx = j;
                        maxElements = dp[j].size();
                    }
                }
            }
            dp[i].add(nums[i]);
            if(i != idx){
                for(int k : dp[idx]){
                dp[i].add(k);
            }
            }
        }
        int maxEle = 0;
        int idx = 0;
        for(int i=0;i<len;i++){
            if(maxEle < dp[i].size()){
                maxEle = dp[i].size();
                idx = i;
            }
        }
        return dp[idx];
    }
}