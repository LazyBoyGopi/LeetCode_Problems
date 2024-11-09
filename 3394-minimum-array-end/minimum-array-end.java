class Solution {
    private int[] getBit(int ele) {
        int[] ar = new int[64];
        int idx = 63;
        while (ele > 0) {
            ar[idx--] += (ele & 1);
            ele >>= 1;
        }
        return ar;
    }

    public long minEnd(int n, int x) {
        int[]xBit = getBit(x);
        int[]nBit = getBit(--n);
        int i=63, j= 63;
        long ans = 0;
        long curValAtTheBit = 1;
        while(i >= 0){
            if(xBit[i] == 1){
                ans += curValAtTheBit;
               
            }else{
                if(nBit[j] == 1){
                    ans += curValAtTheBit;
                }
                j--;
            }
            i--;
            curValAtTheBit *= 2;
        }
        return ans;
    }
}