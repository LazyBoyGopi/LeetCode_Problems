class Solution {
    private void getNumber(int[]nums,int[]freq){
        Set<Integer> set = new HashSet<>();
        for(int ele : nums) {
            if(!set.contains(ele))
            {
                freq[ele]++;
                set.add(ele);
            }
        }
    }
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[]freq = new int[101];
        List<Integer> list = new LinkedList<>();
        getNumber(nums1,freq);
        getNumber(nums2,freq);
        getNumber(nums3,freq);
        for(int i=0;i<101;i++) if(freq[i] >= 2) list.add(i);
        return list;
    }
}