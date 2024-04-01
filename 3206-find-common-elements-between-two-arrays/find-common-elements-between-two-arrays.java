class Solution {
    private int getCount(int[]nums1,int nums2[])
    {
        int count = 0;
        for(int ele : nums1)
        {
            for(int ele2 : nums2)
            {
                if(ele == ele2)
                {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        return new int[]{getCount(nums1,nums2),getCount(nums2,nums1)};
    }
}