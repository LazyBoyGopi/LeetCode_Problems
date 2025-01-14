class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int len = A.length;
        int[]ans = new int[len];
        for(int i=0;i<len;i++){
            int common = 0;
            for(int j=0;j<=i;j++){
                int curEle = A[j];
                for(int k=0;k<=i;k++){
                    if(curEle == B[k]) common++;
                }
            }
            ans[i] = common;
        }
        return ans;
    }
}