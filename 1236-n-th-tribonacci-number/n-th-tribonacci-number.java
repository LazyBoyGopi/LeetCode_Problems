class Solution {
    static final int[]ar = new int[38];
    int lastIdx = 3;
    static{
        ar[0] = 0;
        ar[1] = 1;
        ar[2] = 1;
    }
    private void calc(int n){
        for(int i=lastIdx;i<=n;i++){
            ar[i] = ar[i-1]+ar[i-2]+ar[i-3];
        }
        lastIdx = n;
    }
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n <= 2) return 1;
        if(ar[n] == 0){
            calc(n);
        }
        return ar[n];
    }
}