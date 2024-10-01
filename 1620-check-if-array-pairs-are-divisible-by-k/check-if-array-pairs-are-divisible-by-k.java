class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[]ar = new int[k];
        int len = arr.length;
        for(int i=0;i<len;i++){
            int rem = arr[i] % k;
            if(rem < 0) rem += k;
            ar[rem]++;
        }
        if(ar[0] % 2 != 0) return false;
        int half = k/2;
        for(int i=1;i<=half;i++){
            if(ar[k-i] != ar[i]) return false;
        }
        return true;
    }
}