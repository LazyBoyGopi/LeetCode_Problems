class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int idx1 = 0 , idx2 = 0 , len1 = nums1.length , len2 = nums2.length;
        List<Integer>list = new ArrayList<>();
        while(idx1 < len1 && idx2 < len2){
            if(nums1[idx1] == nums2[idx2]) {
                list.add(nums1[idx1]);
                idx1++;
                idx2++;
            }
            else if(nums1[idx1] > nums2[idx2]){
                idx2++;
            }
            else idx1++;
        }
        int[]ar = new int[list.size()];
        for(int i=0;i<ar.length;i++){
            ar[i] = list.get(i);
        }
        return ar;
    }
}