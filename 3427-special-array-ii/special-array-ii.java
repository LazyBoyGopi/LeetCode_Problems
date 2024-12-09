class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int len = nums.length;
        int[]maxLen = new int[len];
        boolean isEven = nums[0]%2==0;
        maxLen[0] = 1;
        for(int i=1;i<len;i++){
            boolean flag = true;
            int lastBit = nums[i] & 1;
            if(isEven){
                if(lastBit == 0) flag = false;
            }else if(lastBit == 1) flag = false;
            maxLen[i] = flag ? maxLen[i-1]+1 : 1;
            isEven = lastBit == 0;
        }
        len = queries.length;
        boolean []ans = new boolean[len];
        for(int i=0;i<len;i++){
            int[]query = queries[i];
            int longestLen = maxLen[query[1]];
            ans[i] = query[1]-query[0]+1 <= longestLen;
        }
        return ans;
    }
}