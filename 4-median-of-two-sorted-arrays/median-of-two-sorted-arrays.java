class Solution {
    private int[]merge(int[]nums1,int[]nums2){
        int idx1 = 0 , idx2 = 0 , idx = 0 , len1 = nums1.length , len2 = nums2.length;
        int[]nums = new int[len1+len2];
        while(idx1 < len1 && idx2 < len2){
            if(nums1[idx1] > nums2[idx2]){
                nums[idx++] = nums2[idx2++];
            }else{
                nums[idx++] = nums1[idx1++];
            }
        }
        while(idx1 < len1) nums[idx++] = nums1[idx1++];
        while(idx2 < len2) nums[idx++] = nums2[idx2++];
        return nums;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int []nums = merge(nums1,nums2);
        if(nums.length % 2 == 0){
            int mid = nums.length/2;
            double sum = (double)nums[mid]+nums[mid-1];
            return sum/2;
        }
        return nums[nums.length/2];
    }
}