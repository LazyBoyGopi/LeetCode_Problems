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
        // return new int[]{getCount(nums1,nums2),getCount(nums2,nums1)};
        boolean[] b1 = new boolean[101];
        boolean[] b2 = new boolean[101];
        for(final int ele : nums1) b1[ele] = true;
        for(final int ele : nums2) b2[ele] = true;
        int c1 = 0 , c2 =0;
        for(final int ele : nums1)
        {
            if(b2[ele]) c1++;
        }
        for(final int ele : nums2)
        {
            if(b1[ele]) c2++;
        }
        return new int[]{c1,c2};
    }
}