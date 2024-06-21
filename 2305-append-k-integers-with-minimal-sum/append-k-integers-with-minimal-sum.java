class Solution {
    public long minimalKSum(int[] nums, int k) {
        int idx = 0;
        long ans = 0;
        Arrays.sort(nums);
        if (idx == 0 && nums[idx] != 1) {
            int first = 1, last = nums[idx] - 1;
            int diff = last - first + 1;
            if (diff >= k) {
                last = first + k-1;
                long sum = ((long) k * (first + last)) / 2;
                ans += sum;
                return ans;
            } else {
                long sum = ((long) diff * (first + last)) / 2;
                ans += sum;
                k -= diff;
            }
        }
        while (k > 0) {
            if (idx < nums.length - 1) {
                int diff = nums[idx + 1] - nums[idx] - 1;
                long sum;
                if (diff > 0) {
                    if (diff >= k) {
                        int first = nums[idx] + 1;
                        int last = nums[idx] + k;
                        sum = ((long) k * (first + last)) / 2;
                        ans += sum;
                        return ans;
                    } else {
                        int first = nums[idx] + 1;
                        int last = nums[idx + 1] - 1;
                        sum = ((long) diff * (first + last)) / 2;
                        k -= diff;
                        ans += sum;
                    }
                }
                idx++;
            } else {
                int firstNum = nums[idx] + 1;
                int lastNum = nums[idx] + k;
                long sum = ((long) k * (lastNum + firstNum)) / 2;
                ans += sum;
                return ans;
            }
        }
        return ans;
    }
}