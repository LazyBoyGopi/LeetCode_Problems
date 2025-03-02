class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int p1 = 0, p2 = 0, l1 = nums1.length, l2 = nums2.length;
        int[] sum = new int[1001];
        for(int [] ar : nums1){
            sum[ar[0]] = ar[1];
        }
        int uni = l1;
        for(int [] ar : nums2){
            int ele = sum[ar[0]];
            if(ele == 0){
                uni++;
            }
            sum[ar[0]] += ar[1];
        }
        int[][]ans = new int[uni][2];
        int idx = 0;
        for(int i=0;i<=1000;i++){
            int s = sum[i];
            if(s != 0){
                ans[idx][0] = i;
                ans[idx][1] = s;
                idx++;
                if(idx == uni)
                    break;
            }
        }
        return ans;
    }
}