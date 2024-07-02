class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[]ar = new int[1001];
        int[]ans = new int[1000];
        for(int i=0;i<nums1.length;i++){
            ar[nums1[i]]++;
        }
        int idx = 0;
        for(int i=0;i<nums2.length;i++){
            if(ar[nums2[i]] > 0){
                ans[idx++] = nums2[i];
                ar[nums2[i]]--;
            }
        }
        return Arrays.copyOfRange(ans,0,idx);
    }
}