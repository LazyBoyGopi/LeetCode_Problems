class Solution {
    /*private int findMax(int[]nums){
        int max = nums[0];
        for(int ele : nums) max = Math.max(max,ele);
        return max;
    }
    private int findStart(int[]nums,int target){
        int st = 0, end = nums.length-1;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(nums[mid] < target) st = mid+1;
            else end = mid-1;
        }
        return st;
    } */
    private boolean isPossible(int mb,int[]nums, int mo){
        int c = 0;
        for(int e : nums){
            int o = (e-1)/mb;
            c += o;
            if(c > mo) return false;
        }
        return true;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1,r = (int)Math.pow(10,9);
        // Arrays.sort(nums);
        while(l <= r){
            int m = (l+r)/2;
            if(isPossible(m,nums,maxOperations)){
                r = m-1; 
            }
            else l = m+1;
        }
        return l;
    }
}