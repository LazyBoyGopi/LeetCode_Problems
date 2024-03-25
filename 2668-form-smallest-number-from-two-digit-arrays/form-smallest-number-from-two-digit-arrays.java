class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int first = 0 , second = 0;
        while(first < nums1.length && second < nums2.length)
        {
            if(nums1[first] == nums2[second] ) return nums1[first];
            if(nums1[first] > nums2[second]) second++;
            else first++;
        }
        if(nums1[0] > nums2[0]) return (nums2[0]*10)+nums1[0];
        return (nums1[0]*10)+nums2[0];
    }
}