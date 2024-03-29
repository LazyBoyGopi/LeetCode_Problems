class Solution {
    private boolean doesContains(int nums[],int ele)
    {
        for(int ele1 : nums)
        {
            if(ele1 == ele) return false;
        }
        return true;
    }
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(int ele : nums1)
        {
            if(doesContains(nums2,ele))set.add(ele);
        }
        list.add(new LinkedList<>(set));
        set.clear();
        for(int ele : nums2)
        {
            if(doesContains(nums1,ele))set.add(ele);
        }
        list.add(new LinkedList<>(set));
        set.clear();
        return list;
    }
}