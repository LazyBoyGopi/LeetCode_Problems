class Solution {
    public int largestCombination(int[] candidates) {
        int len = candidates.length;
        int[]ar = new int[24];
        for(int i=0;i<len;i++){
            int ele = candidates[i];
            int idx = 23;
            while(ele > 0){
                ar[idx--] += (ele & 1);
                ele >>= 1;
            }
        }
        int max = 0;
        for(int i=0;i<24;i++){
            max = Math.max(ar[i],max);
        }
        return max;
    }
}