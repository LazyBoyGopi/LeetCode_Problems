class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        ganesh : for(int i=0;i<nums.length;i++){
            gopi : for(int j=i+1;j<nums.length;j++){
                int tempTarget = nums[i] + nums[j];
                if(tempTarget == target){
                    ans[0] = i;
                    ans[1] = j;
                    break ganesh;
                }
            }
        }
        return ans;
    }
}