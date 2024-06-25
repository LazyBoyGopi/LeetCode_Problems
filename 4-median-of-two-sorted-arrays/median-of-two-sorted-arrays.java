class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length , len2 = nums2.length , e1 = -1 , e2 = -1 , i = 0 , j = 0 , m2 = (len1+len2)/2 , m1 = m2-1 , c1 = 0 ;
        while(i < len1 && j < len2){
            if(nums1[i] < nums2[j]){
                if(c1 == m1) e1 = nums1[i];
                if(c1 == m2) e2 = nums1[i];
                i++;
            }
            else{
                if(c1 == m1) e1 = nums2[j];
                if(c1 == m2) e2 = nums2[j];
                j++;
            }
            c1++;
            if(e1 != -1 && e2 != -1) break;
        }
        while(i < len1){
            if(c1 == m1) e1 = nums1[i];
            if(c1 == m2) e2 = nums1[i];
            i++;
            c1++;
            if(e1 != -1 && e2 != -1) break;
        }
        while(j < len2){
            if(c1 == m1) e1 = nums2[j];
            if(c1 == m2) e2 = nums2[j];
            j++;
            c1++;
            if(e1 != -1 && e2 != -1) break;
        }
        if((len1+len2) %2 == 0){
            if(e1 == -1) return e2;
            if(e2 == -1) return e1;
            return ((double)e1+e2)/2;
        }
        return e2;
    }
}