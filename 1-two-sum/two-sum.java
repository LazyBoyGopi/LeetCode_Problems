class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int tempTarget = nums[i] + nums[j];
                if(tempTarget == target){
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
            if(ans[0] != 0 || ans[1] != 0) {
                break;
            }
        }
        return ans;
    }
}