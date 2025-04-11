class Solution {
    public int maximumJumps(int[] nums, int target) {
        int len = nums.length;
        int[]dp = new int[len];
        boolean[]isPossible = new boolean[len];
        isPossible[len-1] = true;
        Arrays.fill(dp,-1);
        dp[len-1] = 0;
        int isPos = len-1;
        for(int i=len-2;i>=0;i--){
            int max = -1;
            int idx = -1;
            for(int j=i+1;j<len;j++){
                int t = nums[j]-nums[i];
                if(-target <= t && t <= target && isPossible[j])
                   {
                        idx = j;
                        max = Math.max(max,dp[j]);
                   }
            }
            if(idx != -1){
                isPos = i;
                isPossible[i] = true;
            }
            dp[i] = max+1;
        }
        System.out.println(Arrays.toString(dp));
        return isPos == 0 ? dp[0] : -1;
    }
}