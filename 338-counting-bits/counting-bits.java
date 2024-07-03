class Solution {
    int[] ar = new int[(int) 1e5+1];
    private int getNumberOfBits(int num){
        if(num <= 1) return num;
        if(ar[num] != 0) return ar[num];
        int count = 0;
        while(num != 0){
            if(num % 2 == 1) count++;
            num >>= 1;
        }
        return ar[num] = count;
    }
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = getNumberOfBits(i);
        }
        return ans;
    }
}