class Solution {
    private int getXOR(int[]nums){
        int xor = 0;
        for(int ele : nums)
            xor ^= ele;
        return xor;
    }
    public int xorAllNums(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length, xor = 0;
        if(l1 % 2 == 0 && l2 % 2 == 0)
            return 0;
        else if(l2 % 2 == 0)
            return getXOR(nums2);
        else if(l1 % 2 == 0)
            return getXOR(nums1);
        return getXOR(nums1) ^ getXOR(nums2);
    }
}