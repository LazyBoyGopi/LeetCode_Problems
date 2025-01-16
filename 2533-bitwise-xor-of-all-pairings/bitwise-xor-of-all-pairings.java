class Solution {
    private int getXor(int []nums){
        int xor = 0, len = nums.length;
        for(int i=0;i<len;i++){
            xor ^= nums[i];
        }
        return xor;
    }
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int xor = 0;
        if((n2 & 1) == 1) xor ^= getXor(nums1);
        if((n1 & 1) == 1) xor ^= getXor(nums2);
        return xor;
    }
}