class Solution {
    private int search(int[] nums, int target, int st, int end, boolean isFirstHalf) {
        int idx = isFirstHalf ? end : st;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (isFirstHalf) {
                if(nums[mid] >= target)
                {
                    end = mid-1;
                }
                else{
                    st = mid+1;
                }
            }
            else{
                if(nums[mid] <= target)
                {
                    st = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return isFirstHalf ? st : end;
    }

    private int[] binarySearch(int[] nums, int target) {
        int st = 0, end = nums.length - 1;
        int[] ans = { -1, -1 };
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] == target) {
                ans[0] = search(nums, target, st, mid, true);
                ans[1] = search(nums, target, mid, end, false);
                return ans;
            }
            if (nums[mid] > target)
                end = mid - 1;
            else
                st = mid + 1;
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        return binarySearch(nums, target);
    }
}