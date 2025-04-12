class Solution {
    private int getMinSteps(int[]dp,int i,int j){
        int minSteps = dp.length;
        while(i<=j){
            if(dp[i] != -1)
                minSteps = Math.min(minSteps,dp[i]);
            i++;
        }
        return minSteps;
    }
    public int jump(int[] nums) {
        int len = nums.length, prev = len-1, steps = 0;
        int[]dp = new int[len];
        for(int i=len-2;i>=0;i--){
            int curMaxIdx = i+nums[i];
            if(curMaxIdx >= len-1){
                steps = 1;
                prev = i;
            }else if(curMaxIdx == prev){
                steps += 1;
                prev = i;
            }else if(curMaxIdx > prev){
                steps = getMinSteps(dp,i+1,curMaxIdx)+1;
                prev = i;
            }else{
                dp[i] = -1;
                continue;
            }
            dp[i] = steps;
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}

