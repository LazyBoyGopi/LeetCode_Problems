class Solution {
    private void getAns(int[]nums,boolean[]freq){
        for(int ele : nums) freq[ele] = true;
    }
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        boolean b1[] = new boolean[101];
        boolean b2[] = new boolean[101];
        boolean b3[] = new boolean[101];
        List<Integer> list = new ArrayList<>();
        getAns(nums1,b1);
        getAns(nums2,b2);
        getAns(nums3,b3);
        for(int i=0;i<101;i++){
            if((b1[i] && b2[i]) || (b2[i] && b3[i]) || (b1[i] && b3[i])){
                list.add(i);
            }
        }
        return list;
    }
}