class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE, len = nums.length, ans = 0 , i = 0;
        while(i < len){
            int j = i+1, k = len-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                int curDiff = Math.abs(sum-target);
                if(curDiff <= diff){
                    diff = curDiff;
                    ans = sum;
                }
                if(sum == target) return target;
                if(sum > target) k--;
                else j++;
            }
            int temp = nums[i];
            while(i < len && temp == nums[i]) i++;
        }
        return ans;
    }
}